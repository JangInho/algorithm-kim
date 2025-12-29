import java.util.*;

public class inf05021 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] board =  new int[n+1][n+1];
        
        for (int i = 0; i<n; i++) {
            for (int j = 0; j <  n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        int m = sc.nextInt();

        int[] moves = new int[m];

        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i<m; i++) {
            moves[i] = sc.nextInt();
        }

        int answer = 0;

        for (int targetCol : moves) {
            for (int i = 0; i<n; i++) {
                if (board[i][targetCol-1] != 0) {
                    if (!st.isEmpty() && (st.peek() == board[i][targetCol-1])) {
                        board[i][targetCol-1] = 0;
                        st.pop();
                        answer++;
                        answer++;
                        break;
                    } else {
                        st.push(board[i][targetCol-1]);
                        board[i][targetCol-1] = 0;
                        break;    
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
