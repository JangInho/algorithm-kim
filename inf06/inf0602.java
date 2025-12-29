import java.util.Scanner;

public class inf0602 {
    
    // 버블정렬
    // 이웃한 두 수를 비교해서 큰거를 뒤로 보내는 정렬방법
    // 내가 한 것보다 답을 이건 외울 필요가 있음

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        arr[n] = Integer.MAX_VALUE;

        // int count = 0;
        // while (count < n) {
        //     count++;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] > arr[i+1]) {
        //             int temp = arr[i];
        //             arr[i] = arr[i+1];
        //             arr[i+1] = temp;
        //         }    
        //     }    
        // }

        // 버블정렬 n^2보다는 적게하는 법
        for (int i = 0; i<n-1; i++) {
            for (int j = 0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                } 
            }
        }
        
        for (int i =0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
     
}
