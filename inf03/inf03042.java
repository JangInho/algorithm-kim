import java.util.*;

// lt 와 rt 사이의 합이 sum 이 된다는게 중요하다
public class inf03042 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int targetSum = sc.nextInt();
        int[] arr = new int[cnt];
        
        for (int i=0; i<cnt; i++) {
            arr[i] = sc.nextInt(); 
        }

        int answer = 0;
        int sum=0;
        int lt =0;

        for (int rt = 0; rt<cnt; rt++) {
            sum += arr[rt];

            if (sum == targetSum) {
                answer++;
            }

            // if (sum > targetSum) {
                while (sum > targetSum) {
                    sum -= arr[lt++];
                    if (sum == targetSum) {
                        answer++;
                    }
                }
            // }

         }

         System.out.println(answer);
        
        
    }
}
