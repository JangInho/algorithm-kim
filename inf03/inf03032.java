import java.util.*;


/**
 * sliding window 알고리즘, 앞에꺼 더하고 맨뒤에꺼 빼기
 * 0303에서 O(n^2)나와서 타임아웃 -> 03031에서 O(n^2) -> O(n) 으로 해서 시도했는데 코드가 썩 맘에 들진않았음
 */
public class inf03032 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int seq = sc.nextInt();
        int[] arr = new int[cnt];
        
        for(int i =0; i<cnt; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int answer = 0;

        for (int i= 0; i< seq; i++) {
            sum += arr[i];
        }
        answer = sum;
        
        for (int i = seq; i<cnt - seq; i++) {
            sum -= arr[i-seq];
            sum += arr[i];

           answer = Math.max(answer, sum);
        }

        System.out.println(answer);
        
    }
}
