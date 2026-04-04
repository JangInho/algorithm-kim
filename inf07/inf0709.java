import java.util.*;


// 말단 노드까지의 가장 짧은 경로
public class inf0709 {
    
    static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = this.rt = null;
        }
    }

    Node root;

    // 여기는 레벨도 같이 받아서 가장 짧은 레벨을 출력하는 걸로 가자
    // 이거 형식은 외우는 것도 좋을 것 같기도함 함축되어서 많이
    int DFS(int level, Node root) {
        
        // 말단 노드라면
        if (root.lt == null && root.rt==null) {
            return level;   
        } else {
            return Math.min(DFS(level+1, root.lt), DFS(level+1, root.rt));
        }
        
    }
    
    public static void main(String[] args) {
        inf0709 tree = new inf0709();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.println(tree.DFS(0, tree.root));
        
    }
}
