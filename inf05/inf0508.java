import java.util.*;
import java.util.LinkedList;

public class inf0508 {   

    private static class Node {
        public int num;
        public boolean isTarget;
        
        public Node(int num, boolean isTarget) {
         this.num = num;
         this.isTarget = isTarget;
        }
     }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        Queue<Node> rank = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<n; i++) {
            int temp = sc.nextInt();
            Node newNode = new Node(temp, i == m ? true : false);
            rank.offer(newNode);
            
            if (temp > max) {
                max = temp;
            }
        }


        int answer = 0;

        while (!rank.isEmpty()) {
            if (max <= rank.peek().num) {

                answer++;
                
                if (rank.peek().isTarget) {
                    System.out.println(answer);
                }

                rank.poll();

                // max찾기
                int newMax = Integer.MIN_VALUE;
                for (Node tempMax: rank) {
                    if (tempMax.num > newMax) {
                        newMax = tempMax.num;
                    }
                }
                max = newMax;
            } else {    
                rank.offer(rank.poll());
            }    
        }

    }
}
