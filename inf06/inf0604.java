import java.util.*;

public class inf0604 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int a : arr) {

            if (qu.contains(a)) {
                qu.remove(a);
                qu.offer(a);

            } else if (qu.size() >= s) {
                qu.poll();
                qu.offer(a);
                
            } else {
                qu.offer(a);
                
            }
        }
        

        Stack<Integer> st = new Stack<>();
        
        int count = 0;
        while (count < s) {
            count++;
            st.push(qu.poll());
        }
        
        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        
    }
}
