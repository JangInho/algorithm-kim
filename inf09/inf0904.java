

import java.util.*;

public class inf0904 {

    static int n, m;
    static int[] pm;
    
    public static void DFS(int i) {
        
        if (i == m) {
            
            for (int k = 0; k < m; k++) {
                System.out.print(pm[k] + " ");
            }
            System.out.println();

        } else {
            
            for (int k = 0; k < n; k++) {
                pm[i] = k + 1;
                DFS(i+1);
            }

        }
        
    }

    public static void main(String[] args) {
        // 1부터 N까지 번호가 적인 구슬이 있다
        // 이 중 중복을 허락하여 M번을 뽑아 일려로 나열하는 방법을 모두 출력
        
        // 출력 순서는 사전순으로 오름차순으로 출력한다
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        
        DFS(0);

        
    }
}
