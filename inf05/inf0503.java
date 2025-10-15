import java.util.Scanner;

public class inf0503 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int k= 0; k<n; k++) {
                board[i][k] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];

        for(int i =0; i<m; i++) {
            moves[i] = sc.nextInt();
        }

        
    }

}
