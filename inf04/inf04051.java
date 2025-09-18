import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Comparator;

// TreeSet버전으로 풀어보기
public class inf04051 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> tSet = new TreeSet<>(Comparator.reverseOrder());

        for(int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for(int l=j+1; l<n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        int answer = -1;
        for(int a : tSet) {
            cnt++;

            if(cnt == k) {
                answer = a;
            }
        }

        System.out.println(answer);
    }

}
