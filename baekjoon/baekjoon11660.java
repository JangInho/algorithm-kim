import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon11660 {
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        int[][] prefixSum = new int[n+1][n+1];
        
        for (int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j<=n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if (j == 1) {
                    prefixSum[i][j] = prefixSum[i-1][n] + arr[i][j];    
                } else {
                    prefixSum[i][j] = prefixSum[i][j-1] + arr[i][j];    
                }
                
                // System.out.print(prefixSum[i][j] + " ");
            }

            // System.out.println();
        }

        for (int i =0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // System.out.println(x2 + ", " + y2 + " = " + prefixSum[x2][y2]);
            // System.out.println(x1 + ", " + y1 + " = " + prefixSum[x1][y1]);

            if (y1 == 1) {
                System.out.println(prefixSum[x2][y2] - prefixSum[x1-1][n]);    
            } else {
                System.out.println(prefixSum[x2][y2] - prefixSum[x1][y1-1]);
            }

            
        }
        
    }
}
