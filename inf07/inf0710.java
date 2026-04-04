import java.util.*;


// 말단 노드까지의 가장 짧은 경로
public class inf0710 {
    
    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = this.rt = null;
        }
    }

    Node root;

    
    int BFS(Node root) {
        
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        
        int ans = Integer.MAX_VALUE;
        
        int level = 0;
        
        while (!q.isEmpty()) {
            
            int len = q.size();
            
            for (int i= 0; i<len; i++) {
                Node tmp = q.poll();

                // 어차피 여기서 검사했을 때 가장 먼저 null null인게 가장 짧은 경로니까 여기서는 그냥 리턴해버려도 된다
                if (tmp.lt == null && tmp.rt == null && ans > level) ans = level;
                // if (tmp.lt == null && tmp.rt == null) return level;
                
                if (tmp.lt != null) q.offer(tmp.lt);
                if (tmp.rt != null) q.offer(tmp.rt);
            }
            level++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        inf0710 tree = new inf0710();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.BFS(tree.root));
        
    }
}
