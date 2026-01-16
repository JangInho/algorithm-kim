import java.util.LinkedList;
import java.util.Queue;

class inf0707 {

    static class Node {
        int data;
        Node lt, rt;
        
        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    Node root;

    public void BFS(Node root) {

        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.offer(root);

        

        while (!q.isEmpty()) {
            
            int len = q.size();    

            System.out.print("level: ");
            for (int i =0; i < len; i++) {
                Node tmp = q.poll();
                
                System.out.print(tmp.data + " ");
                
                if (tmp.lt != null) {
                    q.offer(tmp.lt);
                }
                
                if (tmp.rt != null) {
                    q.offer(tmp.rt);
                }
            }
            System.out.println();

            level++;
        }
        
    }
    
    // 이진트리 BFS 레벨 탐색
    // 최단 거리 구할 때 쓴다고 함
    // 큐를 사용하고 레벨탐색을 할 때 사용함
    public static void main(String[] args) {

        inf0707 tree = new inf0707();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);

        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        
        tree.BFS(tree.root);
        
    }
}