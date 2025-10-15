import java.util.Scanner;

public class inf0602 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ; i< n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i =0; i<n; i++) {
            for (int j =0; j < n-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }    
            }
            
        }
        
        
        
    }
     
}
