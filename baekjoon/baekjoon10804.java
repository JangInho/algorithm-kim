import java.util.*;

public class baekjoon10804 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[21];
        for (int i=1; i<=20; i++) {
            arr[i] = i;
        }

        for (int i =0; i<10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            while (a<b) {
                int tmp = 0;
                tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;    
                a++;
                b--;
            }
        }

        for(int i = 1; i<21; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}
