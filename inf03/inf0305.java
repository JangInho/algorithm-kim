import java.util.Scanner;

// two pointer의 의의는 n^2를 n으로 바꾸는데 있다
// rt를 for문의 index로 가져가는게 중요한 것 같고
// 그런데 왜 이 알고리즘이 답이 되는지는 모르겠음.
public class inf0305 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        
        int sum = 0;
        int lt= 0, rt=0;
        int answer = 0 ;
        
        for (int i =0 ; i<n; i++) {
            arr[i] = i+1;
        }

        sum += arr[0];

        for (int i =0; i<n; i++) {
            
            if (sum == n) {
                answer++;
                sum -= arr[lt++];
                sum += arr[rt++];
            } else if (sum < n) {
                sum += arr[++rt];
            } else if (sum > n) {
                while (sum <= n) {
                    sum -= arr[lt++];
                }
            }
            
        }

        System.out.println(answer);

        
    }
}
