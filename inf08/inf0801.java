import java.util.*;

public class inf0801 {
    

    public static void DFS(int n) {
        if (n == 1 ) {
            System.out.println(n);
            return;
        }
        
        DFS(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        DFS(n);
        
    } 
    
}
