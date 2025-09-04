import java.util.*;


// time out 
public class inf0304 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int targetSum = sc.nextInt();
        int[] arr = new int[cnt];

        for(int i =0; i < cnt; i++ ) {
            arr[i] = sc.nextInt();
        }


        int answer = 0;

        for(int i =1; i<=cnt; i++) {
            int sum = 0;
            for (int k =0; k<i; k++) {
                sum += arr[k];
                if (sum == targetSum) {
                    answer++;
                }
            }

            for (int k =i; k<cnt; k++) {
                sum -= arr[k-i];
                sum += arr[k];
                if (sum == targetSum) {
                    answer++;
                }

            }
        }
        System.out.println(answer);
        
        
    }
}
