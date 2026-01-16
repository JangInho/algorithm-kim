import java.util.*;

public class inf06091 {
    
    static int getCount(int[] arr, int capa) {
        int count = 1;
        int sum = 0;
        for (int a: arr) {
            sum += a;
            if (sum > capa) {
                count++;
                sum = a;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        
        int mid;
        int answer = 0;

        while (lt <= rt) {
            mid = (lt + rt) / 2; 
            
            int count = getCount(arr, mid);
            
            if (count == m) {
                answer = mid;
                rt = mid-1;
            } else if (count < m) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

        System.out.println(answer);
        
    }
}
