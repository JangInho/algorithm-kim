import java.util.Scanner; 

public class inf0802 {

    public static void DFS(int n) {
        if (n==0) {
            return;
        } else {
            // System.out.println(n%2);
            DFS(n/2);
            System.out.println(n%2);
        }
    }
     
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        DFS(n);
        
    }
}
