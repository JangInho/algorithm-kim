

class Node {
    int data;
    Node lt, rt;
    
    public Node(int data) {
        this.data = data;
        lt=rt=null;
    }
}

// DFS 깊이 우선 탐색
public class inf0705 {
    Node root;

    static void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            // System.out.print(root.data + " "); // 전위 
            
            DFS(root.lt); 

            System.out.print(root.data + " "); // 중위 

            DFS(root.rt);

            // System.out.print(root.data + " "); // 후위 
        }
    }
    
    public static void main(String[] args) {
        inf0705 tree = new inf0705();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        DFS(tree.root);
        
        
    }
}
