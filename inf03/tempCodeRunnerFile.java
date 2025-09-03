import java.util.Scanner;
import java.util.ArrayList;

public class inf03031 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        
        int seq = sc.nextInt();
        
        int[] arr = new int[cnt];

        for(int i =0; i<cnt; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0; 
        ArrayList<Integer> sumArr = new ArrayList<>();

        for (int i =0; i<cnt; i++) {

            sum += arr[i];

            if(i >= seq) {
                sum -=arr[i-seq];
                sumArr.add(sum);
            }
            
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
