

import java.util.*;
import java.io.*;

public class TestAnswer {
    static final class Repo {

        static final class Commit {
            final String id;
            final String message;
            final String parentId;
            final Map<String, String> snapshot; // immutable

            Commit(String id, String message, String parentId, Map<String, String> snapshot) {
                this.id = id;
                this.message = message;
                this.parentId = parentId;
                this.snapshot = Collections.unmodifiableMap(snapshot);
            }
        }

        private final Map<String, String> working = new HashMap<>();
        private final Map<String, Optional<String>> staging = new HashMap<>();
        private final Map<String, Commit> commits = new HashMap<>();

        private String mainPointer = null;          // commit id
        private boolean headAttachedToMain = true;  // true => HEAD=main
        private String headCommit = null;           // when detached (or track current)

        private int seq = 0;

        void init() {
            working.clear();
            staging.clear();
            commits.clear();
            seq = 0;

            mainPointer = null;
            headAttachedToMain = true;
            headCommit = null;
        }

        void add(String file, String content) {
            working.put(file, content);
            staging.put(file, Optional.of(content));
        }

        void rm(String file) {
            working.remove(file);
            staging.put(file, Optional.empty());
        }

        void commit(String message) {
            String parent = currentCommitId();
            String id = nextCommitId();

            Map<String, String> snap = snapshotOf(parent);
            applyStagingTo(snap);

            Commit c = new Commit(id, message, parent, snap);
            commits.put(id, c);

            if (headAttachedToMain) {
                mainPointer = id;
            }
            headCommit = id; // update current position either way
            staging.clear();
        }

        void checkout(String nameOrCommit) {
            if ("main".equals(nameOrCommit)) {
                headAttachedToMain = true;
                headCommit = mainPointer;
                restoreWorkingFrom(mainPointer);
                staging.clear();
                return;
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
            String cur = currentCommitId();
            while (cur != null) {
                Commit c = commits.get(cur);
                out.println(c.id + " " + c.message);
                cur = c.parentId;
            }
        }

        void cat(String file, PrintWriter out) {
            out.println(working.getOrDefault(file, ""));
        }

        private String nextCommitId() {
            return "c" + (++seq);
        }

        private String currentCommitId() {
            return headAttachedToMain ? mainPointer : headCommit;
        }

        private Map<String, String> snapshotOf(String commitId) {
            if (commitId == null) return new HashMap<>();
            Commit c = commits.get(commitId);
            return new HashMap<>(c.snapshot);
        }

        private void restoreWorkingFrom(String commitId) {
            working.clear();
            if (commitId == null) return;
            working.putAll(commits.get(commitId).snapshot);
        }

        private void applyStagingTo(Map<String, String> snap) {
            for (var e : staging.entrySet()) {
                String file = e.getKey();
                Optional<String> v = e.getValue();
                if (v.isPresent()) snap.put(file, v.get());
                else snap.remove(file);
            }
        }
    }

    // =========================
    // Parsing / Runner (DO NOT EDIT)
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
        return s.substring(sp + 1).trim();
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
                default -> { /* ignore */ }
            }
            out.flush();
        }
        out.flush();
    }
}
