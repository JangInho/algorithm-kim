import java.util.Scanner;
import java.util.ArrayList;

public class Inf0303 {

    
    public static void main(String argsp[]) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        
        int seq = sc.nextInt();
        
        int[] arr = new int[cnt];

        for(int i =0; i<cnt; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> sumArr = new ArrayList<>();
        int sum =0;

        for (int i=0; i < cnt - seq - 1; i++) {

            for (int k=0; k<seq; k++) {                
                sum += arr[i + k];
            }
            
            sumArr.add(sum);
            sum = 0;
        }

        int max = Integer.MIN_VALUE;
        for (int a : sumArr) {
            if (max < a) {
                max = a;
            }
        }

        System.out.println(max);

    }

}


