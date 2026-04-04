package test;
// import java.io.*;
// import java.util.*;

// /**
//  * MiniGit Template (single file)
//  *
//  * Supported commands (example format):
//  *  init
//  *  add <file> <content...>        // content can contain spaces (rest of line)
//  *  rm <file>                      // stage deletion
//  *  commit <message...>
//  *  log
//  *  branch <name>
//  *  checkout <branchOrCommitId>
//  *  status
//  *  cat <file>
//  *  quit
//  *
//  * Notes:
//  * - Commit is a snapshot: Map<filename, content>
//  * - Branch is a pointer: branchName -> commitId
//  * - HEAD is either attached to a branch or detached on a commit
//  */
// public class MiniGit {

//     // ======== Data Models ========

//     static final class Commit {
//         final String id;
//         final String message;
//         final String parentId;                 // single parent (merge omitted)
//         final Map<String, String> snapshot;    // immutable snapshot

//         Commit(String id, String message, String parentId, Map<String, String> snapshot) {
//             this.id = id;
//             this.message = message;
//             this.parentId = parentId;
//             this.snapshot = Collections.unmodifiableMap(snapshot);
//         }
//     }

//     static final class Repo {
//         // working + staging (index)
//         private final Map<String, String> working = new HashMap<>();
//         private final Map<String, Optional<String>> staging = new HashMap<>();
//         // Optional.empty() means deletion staged

//         // objects + refs
//         private final Map<String, Commit> commits = new HashMap<>();
//         private final Map<String, String> branches = new HashMap<>(); // branch -> commitId (nullable)
//         private String headBranch = null;  // if attached, name of branch
//         private String headCommit = null;  // current commit id (also used for detached HEAD)

//         private int commitSeq = 0;

//         void init() {
//             working.clear();
//             staging.clear();
//             commits.clear();
//             branches.clear();
//             commitSeq = 0;

//             headBranch = "main";
//             headCommit = null;
//             branches.put("main", null);
//         }

//         void add(String file, String content) {
//             requireInit();
//             working.put(file, content);
//             staging.put(file, Optional.of(content));
//         }

//         void rm(String file) {
//             requireInit();
//             working.remove(file);
//             staging.put(file, Optional.empty());
//         }

//         void commit(String message) {
//             requireInit();

//             String parent = currentCommitId();
//             String id = nextCommitId();

//             Map<String, String> base =
//                     (parent == null) ? new HashMap<>() : new HashMap<>(commits.get(parent).snapshot);

//             // apply staging
//             for (var e : staging.entrySet()) {
//                 String file = e.getKey();
//                 Optional<String> v = e.getValue();
//                 if (v.isPresent()) base.put(file, v.get());
//                 else base.remove(file);
//             }

//             Commit c = new Commit(id, message, parent, base);
//             commits.put(id, c);

//             // move HEAD
//             if (headBranch != null) branches.put(headBranch, id);
//             headCommit = id;

//             staging.clear();
//         }

//         void branch(String name) {
//             requireInit();
//             branches.put(name, currentCommitId());
//         }

//         void checkout(String target) {
//             requireInit();

//             if (branches.containsKey(target)) {
//                 // attach to branch
//                 headBranch = target;
//                 headCommit = branches.get(target);
//                 restoreWorkingFrom(headCommit);
//                 staging.clear();
//                 return;
//             }

//             if (commits.containsKey(target)) {
//                 // detached
//                 headBranch = null;
//                 headCommit = target;
//                 restoreWorkingFrom(headCommit);
//                 staging.clear();
//                 return;
//             }

//             throw new IllegalArgumentException("Unknown branch/commit: " + target);
//         }

//         void log(PrintWriter out) {
//             requireInit();
//             String cur = currentCommitId();
//             while (cur != null) {
//                 Commit c = commits.get(cur);
//                 out.println(c.id + " " + c.message);
//                 cur = c.parentId;
//             }
//         }

//         void status(PrintWriter out) {
//             requireInit();
//             out.println("HEAD: " + (headBranch != null ? ("branch " + headBranch) : ("detached " + headCommit)));
//             out.println("Branches: " + branches.keySet());
//             out.println("Staged: " + staging.keySet());
//         }

//         void cat(String file, PrintWriter out) {
//             requireInit();
//             out.println(working.getOrDefault(file, ""));
//         }

//         // ===== helpers =====

//         private void requireInit() {
//             if (branches.isEmpty() && commits.isEmpty() && headBranch == null && headCommit == null) {
//                 throw new IllegalStateException("Repository not initialized. Run `init`.");
//             }
//         }

//         private String currentCommitId() {
//             if (headBranch != null) return branches.get(headBranch);
//             return headCommit;
//         }

//         private void restoreWorkingFrom(String commitId) {
//             working.clear();
//             if (commitId == null) return;
//             working.putAll(commits.get(commitId).snapshot);
//         }

//         private String nextCommitId() {
//             // simple increasing IDs: c1, c2, ...
//             return "c" + (++commitSeq);
//         }
//     }

//     // ======== Command Runner ========

//     public static void main(String[] args) throws Exception {
//         Repo repo = new Repo();

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

//         String line;
//         while ((line = br.readLine()) != null) {
//             line = line.trim();
//             if (line.isEmpty()) continue;

//             String cmd = firstToken(line);
//             String rest = restOfLine(line);

//             try {
//                 switch (cmd) {
//                     case "init" -> repo.init();
//                     case "add" -> {
//                         // add <file> <content...>
//                         String file = firstToken(rest);
//                         String content = restOfLine(rest);
//                         repo.add(file, content == null ? "" : content);
//                     }
//                     case "rm" -> repo.rm(rest);
//                     case "commit" -> repo.commit(rest == null ? "" : rest);
//                     case "log" -> repo.log(out);
//                     case "branch" -> repo.branch(rest);
//                     case "checkout" -> repo.checkout(rest);
//                     case "status" -> repo.status(out);
//                     case "cat" -> repo.cat(rest, out);
//                     case "quit" -> { out.flush(); return; }
//                     default -> out.println("error: unknown command: " + cmd);
//                 }
//             } catch (Exception e) {
//                 out.println("error: " + e.getMessage());
//             }

//             out.flush();
//         }
//         out.flush();
//     }

//     private static String firstToken(String s) {
//         if (s == null) return null;
//         s = s.trim();
//         if (s.isEmpty()) return "";
//         int sp = s.indexOf(' ');
//         return (sp == -1) ? s : s.substring(0, sp);
//     }

//     private static String restOfLine(String s) {
//         if (s == null) return null;
//         s = s.trim();
//         if (s.isEmpty()) return "";
//         int sp = s.indexOf(' ');
//         if (sp == -1) return null;
//         return s.substring(sp + 1).trim();
//     }
// }

import java.util.*;

public class MiniGit {
    static class Commit {
        final String id;
        final String message;
        final String parentId;          // 단순화: 부모 1개(merge는 나중에 확장)
        final Map<String, String> snapshot; // 파일명 -> 내용 (스냅샷)

        Commit(String id, String message, String parentId, Map<String, String> snapshot) {
            this.id = id;
            this.message = message;
            this.parentId = parentId;
            this.snapshot = snapshot;
        }
    }

    static class Repo {
        // working directory / staging
        private final Map<String, String> working = new HashMap<>();
        private final Map<String, String> staging = new HashMap<>();

        // git objects
        private final Map<String, Commit> commits = new HashMap<>();
        private final Map<String, String> branches = new HashMap<>(); // branchName -> commitId

        private String headBranch = null;   // e.g. "main"
        private String headCommit = null;   // detached HEAD 용 (여기선 거의 안 씀)
        private int commitSeq = 0;

        void init() {
            commits.clear(); branches.clear();
            working.clear(); staging.clear();
            commitSeq = 0;
            // 빈 초기 커밋 하나 만들어도 되고(편함), 아니면 null부터 시작해도 됨
            headBranch = "main";
            headCommit = null;
            branches.put("main", null);
        }

        void add(String file, String content) {
            working.put(file, content);
            staging.put(file, content);
        }

        void commit(String msg) {
            String parent = currentCommitId();
            String id = "c" + (++commitSeq);

            Map<String, String> base = parent == null ? new HashMap<>() : new HashMap<>(commits.get(parent).snapshot);
            // staging 반영
            for (var e : staging.entrySet()) base.put(e.getKey(), e.getValue());

            Commit c = new Commit(id, msg, parent, Collections.unmodifiableMap(base));
            commits.put(id, c);

            // HEAD가 브랜치면 브랜치 포인터 이동
            if (headBranch != null) branches.put(headBranch, id);
            headCommit = id;
            staging.clear();
        }

        void branch(String name) {
            branches.put(name, currentCommitId());
        }

        void checkout(String target) {
            // branch 체크아웃
            if (branches.containsKey(target)) {
                headBranch = target;
                headCommit = branches.get(target);
                restoreWorkingFrom(headCommit);
                staging.clear();
                return;
            }
            // commit id 체크아웃(detached)
            if (commits.containsKey(target)) {
                headBranch = null;
                headCommit = target;
                restoreWorkingFrom(headCommit);
                staging.clear();
                return;
            }
            throw new IllegalArgumentException("Unknown branch/commit: " + target);
        }

        void log() {
            String cur = currentCommitId();
            while (cur != null) {
                Commit c = commits.get(cur);
                System.out.println(c.id + " " + c.message);
                cur = c.parentId;
            }
        }

        String cat(String file) {
            return working.getOrDefault(file, "");
        }

        // helpers
        private String currentCommitId() {
            if (headBranch != null) return branches.get(headBranch);
            return headCommit;
        }

        private void restoreWorkingFrom(String commitId) {
            working.clear();
            if (commitId == null) return;
            working.putAll(commits.get(commitId).snapshot);
        }
    }

    // 예시: 간단한 커맨드 파서
    public static void main(String[] args) {
        Repo repo = new Repo();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ", 3);
            String cmd = parts[0];

            try {
                switch (cmd) {
                    case "init" -> repo.init();
                    case "add" -> repo.add(parts[1], parts.length >= 3 ? parts[2] : "");
                    case "commit" -> repo.commit(parts.length >= 2 ? line.substring(7).trim() : "");
                    case "branch" -> repo.branch(parts[1]);
                    case "checkout" -> repo.checkout(parts[1]);
                    case "log" -> repo.log();
                    case "cat" -> System.out.println(repo.cat(parts[1]));
                    case "quit" -> { return; }
                    default -> System.out.println("unknown command: " + cmd);
                }
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            }
        }
    }
}