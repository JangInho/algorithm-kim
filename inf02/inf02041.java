

import java.util.Scanner;

public class inf02041 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr =  new int[n+1];

        
        for (int i =1; i<3; i++) {
            arr[i] = 1;
        }


        for(int i =3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        for (int i = 1; i<=n; i++) {
            System.out.print(arr[i] + " "); 
        }
        
    }
}
