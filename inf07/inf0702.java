import java.util.*;


// 이진수 출력하기
public class inf0702 {
    
    static void DFS(int n) {
        if (n < 2) {
            System.out.print(n + " ");
            return;
        } else {
            DFS(n/2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        DFS(n);
    }
}
