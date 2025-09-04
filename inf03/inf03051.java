import java.util.Scanner;

public class inf03051 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        int answer = 0;
        
        for (int i = 1; i<=n; i++) {
            arr[i-1] = i;
        }

        int lt =0;

        for(int rt = 0; rt<n; rt++) {
            sum += arr[rt];

            if (sum == n) {
                answer++;
            }

            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n && lt != rt) answer++;
            }
        }

        System.out.println(answer);
        
    }
}
