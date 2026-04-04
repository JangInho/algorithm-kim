import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1929 {
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[b+1];

        for (int i = 2; i<b+1; i++) {
            
            if (arr[i] == 0) {
                if (i >= a) {
                    System.out.println(i); 
                }

                int n  = 1;
                while (i * n <= b) {
                    arr[i*n] = 1;
                    n++;                    
                }
                
            }
            
        }

        
    }

}