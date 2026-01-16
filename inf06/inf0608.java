import java.io.*;
import java.util.*;

public class inf0608 {
    public static void main(String[] args) throws IOException {
        
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());

        // int n = Integer.parseInt(st.nextToken());
        // int target = Integer.parseInt(st.nextToken());

        // st = new StringTokenizer(bf.readLine());
        // int[] arr = new int[n];

        // for (int i =0; i<n; i++) {
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }


        Arrays.sort(arr);

        int lt , rt, mid;
        lt = 0; rt = arr.length-1;
        
        // while 조건을 lt<=rt인거는 외우자
        while (true) {
            mid = (lt + rt) / 2; 
            if (arr[mid] == target) {
                System.out.println(mid+1);
                return;
            } else if (arr[mid] > target) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }    
        }
        
    }
}
