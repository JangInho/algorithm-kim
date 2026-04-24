package inf09;

import java.util.*;

public class inf0901 {

    static int n;
    static int[] arr;
    static int[] ch;

    static boolean result = false;
    
    public static void DFS(int i) {
        
        if (i == n+1) {
            
            int sum1 = 0; // o
            int sum2 = 0; // x
            
            for (int j = 1; j<n+1; j++) {
                if (ch[j] == 1) {
                    sum1 += arr[j]; 
                } else {
                    sum2 += arr[j];
                }
            }

            if (sum1 == sum2) {
                result = true;
            }

        } else {

            ch[i] = 1;
            DFS(i+1);

            ch[i] = 0;
            DFS(i+1);
            
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        ch = new int[n+1];
        
        for (int i = 1; i<n+1; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(1);
        
        System.out.println(result ? "YES" : "NO");
        

    }
}
