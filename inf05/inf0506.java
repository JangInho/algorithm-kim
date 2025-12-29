import java.util.*;
import java.util.LinkedList;

public class inf0506 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> ll = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++ ) {
            ll.offer(i);
        }

        while (ll.size() > 1) {
            for (int i = 1; i < k; i++) {
                ll.offer(ll.poll());
            }
            ll.poll();    
        }

        System.out.println(ll.poll());

    }
}
