import java.util.*;

public class inf0606 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] originArr = new int[n];
        for (int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
            originArr[i] = arr[i];
        }

        for (int i = 1; i<n; i++) {
            int tmp = arr[i];
            int j;
            for (j = i-1; j>=0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }


        ArrayList<Integer> idxs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (arr[i] != originArr[i]) {
                idxs.add(i);
            }
        }

    
        
        for (int a : idxs) {
            System.out.print(a+1 + " ");
        }
        
    }
}
