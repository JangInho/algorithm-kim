import java.util.*;

public class inf0708 {
    

    // BFS 송아지 찾기  - Brute force
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        int me = sc.nextInt();
        int target = sc.nextInt();

        int diff = target - me;
        
        int count = 0;
        if (diff >= 3) {
            
            count = diff / 5;

            System.out.println(count);
            
            int remain = diff % 5;

            System.out.println(remain);
            
            if (remain >= 3) {
                remain = 5 - remain + 1;
            } 
            
            System.out.println(count + remain);            
            return; 
        } else {
            
            System.out.println(Math.abs(diff));
            return;
        }
    }
}
