import java.util.*;

public class inf0806 {

    static int n = 0;
    static int[] ch;
    

    public static void DFS(int l) {

        if (l == n+1) {
            for (int i =1; i < n+1; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");   
                }
            }

            System.out.println();

        } else {
            
            ch[l] = 1;
            DFS(l+1);

            ch[l] = 0;
            DFS(l+1);
        }
        
    }
    
    public static void main(String[] args) {
    
        // 1~N 까지 원소를 갖는 부분집합을 모두 출력하라
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ch = new int[n+1];

        DFS(1);
    }
    
}
