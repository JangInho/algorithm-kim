import java.util.*;

public class baekjoon2747 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // 피보나치 수는 앞에 두개 더하기
        int[] arr = new int[n+1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.println(arr[n]);
    }
}
