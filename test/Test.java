
import java.io.*;
import java.util.*;

public class Test {

    // =========================
    // 이 클래스를 구현하세요
    // =========================
    static final class Repo {

        static final class Commit {
            final String id;
            final String message;
            final String parentId;              // single parent
            final Map<String, String> snapshot; // file -> content (immutable preferred)

            Commit(String id, String message, String parentId, Map<String, String> snapshot) {
                this.id = id;
                this.message = message;
                this.parentId = parentId;
                this.snapshot = snapshot;
            }
        }

        // working directory 현재 파일 상태 
        private final Map<String, String> working = new HashMap<>();  
        // staging: file -> Optional(content). empty means deletion staged
        private final Map<String, Optional<String>> staging = new HashMap<>();
        // commits
        private final Map<String, Commit> commits = new HashMap<>();

        // branch pointer (only main)
        private String mainPointer = null;  // commitId (nullable)

        // HEAD
        private boolean headAttachedToMain = true; // true => HEAD=main, false => detached
        private String headCommit = null;          // current commit id in detached, also can track current

        private int seq = 0;

        // ---------- TODO: 아래를 구현하세요 ----------

        void init() {
            // TODO: 모든 상태를 초기화하세요. mainPointer=null, HEAD는 main에 붙어있는 상태(attached).

            working.clear();
            staging.clear();
            commits.clear();
            
            seq = 0; // 커밋에 붙는 숫자
            
            mainPointer = null;
            headAttachedToMain = true;
            headCommit = null;
        }

        void add(String file, String content) {
            // TODO: working.put, staging.put(Optional.of(content)) 수행
            working.put(file, content);
            staging.put(file, Optional.of(content));
        }

        void rm(String file) {
            // TODO: working.remove, staging.put(Optional.empty()) 수행(삭제 스테이징)
            working.remove(file);
            staging.put(file, Optional.empty());
        }

        void commit(String message) {
            // TODO:
            // 1) parent = currentCommitId()
            // 2) new snapshot = (parent snapshot을 복사하거나, 없으면 빈 맵) 만든 뒤 staging 적용
            // 3) commit cN 생성/저장, attached면 mainPointer 이동, headCommit 갱신, staging 비우기

            String parent = currentCommitId();
            String id = nextCommitId();

            Map<String, String> snap = snapshotOf(parent);
            applyStagingTo(snap);

            Commit c = new Commit(id, message, parent, snap);
            commits.put(id, c);

            if (headAttachedToMain) {
                mainPointer = id;
            }
            
            headCommit = id;
            staging.clear();
            
        }

        void checkout(String nameOrCommit) {
            // TODO:
            // "main"이면: attached=true, headCommit=mainPointer, working을 mainPointer 스냅샷으로 복원
            // 그 외(커밋ID)이면: detached=true, headCommit=nameOrCommit, working을 해당 커밋 스냅샷으로 복원
            // 마지막에 staging 비우기
            
            if ("main".equals(nameOrCommit)) {
                headAttachedToMain = true;
                headCommit = mainPointer;
                restoreWorkingFrom(mainPointer);
                staging.clear();
            }

            if (!commits.containsKey(nameOrCommit)) {
                throw new IllegalArgumentException("Unknown commit: " + nameOrCommit);
            }

            headAttachedToMain = false; // detached
            headCommit = nameOrCommit;
            restoreWorkingFrom(nameOrCommit);
            staging.clear();
            
        }

        void log(PrintWriter out) {
            // TODO: currentCommitId()부터 시작해서 parentId를 따라가며 "id message"를 출력
            
            String cur = currentCommitId();
            while (cur != null) {
                Commit c = commits.get(cur);
                out.println(c.id + " " + c.message);
                cur = c.parentId;
            }

        }

        void cat(String file, PrintWriter out) {
            // TODO: working.getOrDefault(file, "") 내용을 출력(없으면 빈 줄)
            out.println(working.getOrDefault(file, ""));
        }

        // ---------- helpers ----------

        // 새로운 커밋이 있을때마다 새로운 ID를 발급해주는 함수
        private String nextCommitId() {
            // TODO: "c" + (++seq) 형태로 커밋 ID 생성 (c1, c2, ...)

            return "c" + (++seq);
        }

        private String currentCommitId() {
            // TODO: attached면 mainPointer, detached면 headCommit 반환
            return headAttachedToMain ? mainPointer : headCommit;
        }

        private Map<String, String> snapshotOf(String commitId) {
            // TODO: commitId가 null이면 빈 맵, 아니면 해당 커밋 snapshot을 복사해서 반환(공유 금지)
            if (commitId == null) return new HashMap<>();
            
            Commit c = commits.get(commitId);
            return new HashMap<>(c.snapshot);
        }

        private void restoreWorkingFrom(String commitId) {
            // TODO: working.clear(); commitId가 null이 아니면 snapshot을 working에 putAll로 복원
            working.clear(); 
            if (commitId == null) return;
            working.putAll(commits.get(commitId).snapshot);
        }

        private void applyStagingTo(Map<String, String> snap) {
            // TODO: staging Optional에 따라 snap에 put(수정/추가) 또는 remove(삭제)
            for (var e : staging.entrySet()) {
                String file = e.getKey();
                Optional<String> v = e.getValue();
                if (v.isPresent()) 
                    snap.put(file, v.get());
                else 
                    snap.remove(file);
            }
        }
    }

    // =========================
    // Parsing / Runner (수정 금지)
    // =========================
    private static String firstToken(String s) {
        s = (s == null) ? "" : s.trim();
        if (s.isEmpty()) return "";
        int sp = s.indexOf(' ');
        return (sp < 0) ? s : s.substring(0, sp);
    }

    private static String restOfLine(String s) {
        s = (s == null) ? "" : s.trim();
        if (s.isEmpty()) return "";
        int sp = s.indexOf(' ');
        if (sp < 0) return null;
        return s.substring(sp + 1).trim(); // sp + 1 부터 끝까지 잘라서 나머지
    }

    public static void main(String[] args) throws Exception {
        Repo repo = new Repo();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String cmd = firstToken(line);
            String rest = restOfLine(line);
            
            // System.out.println(cmd);
            // System.out.println(rest);

            switch (cmd) {
                case "init" -> repo.init();
                case "add" -> {
                    String file = firstToken(rest);
                    String content = restOfLine(rest);
                    repo.add(file, content == null ? "" : content);
                }
                case "rm" -> repo.rm(rest);
                case "commit" -> repo.commit(rest == null ? "" : rest);
                case "checkout" -> repo.checkout(rest);
                case "log" -> repo.log(out);
                case "cat" -> repo.cat(rest, out);
                case "quit" -> { out.flush(); return; }
                default -> { /* 무시 */ }
            }
            out.flush();
        }
        out.flush();
    }
}
