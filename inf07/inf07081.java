import java.lang.reflect.Array;
import java.util.*;

public class inf07081 {

    static class Node {
        
        int data; 
        
        Node lf, mid, rt;
        
        public Node(int data) {
            this.data = data;
            lf = mid = rt = null;
        }
    }
    

    Node root;
    
    void BFS(Node root, int me, int target) {
        
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> checked = new ArrayList<>();
        
        int[] dis = {1, -1 , 5};

        q.offer(root); 
        int level = 0;        

        while(!q.isEmpty()) {
            
            int len = q.size();
            
            // System.out.print("lv : " );

            for (int i = 0; i < len; i++) {
                
                Node tmp = q.poll();
                // System.out.print(tmp.data + " ");
                
                
                if (tmp.data != target) {
                    
                    if (!checked.contains(tmp.data)) {
                        checked.add(tmp.data);   
                    }

                    // dis 배열 쓰는거 꿀팁임
                    for (int j=0; j<3; j++) {
                        if (!checked.contains(tmp.data + dis[j])) {
                            q.offer(new Node(tmp.data + dis[j]));
                            checked.add(tmp.data + dis[j]);
                        }
                    }

                } else {
                    
                    System.out.println(level);
                    return;
                }

            }
            // System.out.println();

            level++ ;

        }

    }

    public static void main(String[] args) {

        inf07081 tree = new inf07081();
    
        Scanner sc = new Scanner(System.in);

        int me = sc.nextInt();
        int target = sc.nextInt(); 

        tree.root = new Node(me);

        tree.BFS(tree.root, me, target);    
        
        
    }
    
}
