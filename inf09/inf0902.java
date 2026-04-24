package inf09;
import java.util.*;

public class inf0902 {


    static int c;
    static int n;
    static int max = 0;
    static int[] ch;
    static int[] weight;

    public static void DFS(int i) {
        
        if (i == n+1) {

            int temp = 0;
            for (int k = 1; k<n+1; k++) {
                if(ch[k] == 1) {
                    temp +=  weight[k];
                }
            }

            if (max < temp && temp < c) {
                max = temp;
            }
            
        } else {
            
            ch[i] = 1;
            DFS(i+1);

            ch[i] = 0;
            DFS(i+1);
            
        }

    }


    // 이것도 결국 부분 집합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );

        c = sc.nextInt();
        n = sc.nextInt();

        weight = new int[n+1]; 

        ch = new int[n+1];
        
        for (int i = 1; i<n+1; i++) {
            weight[i] = sc.nextInt();
        }

        DFS(1);

        System.out.println(max);
        
    }
}