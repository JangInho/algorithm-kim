import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon6588 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        int i = Integer.parseInt(st.nextToken());
        
        while ( i != 0) {
            st = new StringTokenizer(br.readLine());
            
            arr.add(i);
            i = Integer.parseInt(st.nextToken());
        }
        
        for (int a : arr) {
            
            int[] tmpArr = new int[a+1];
            tmpArr[0] = 1;
            tmpArr[1] = 1;
            
            // 체
            for (int j =2; j<a+1; j++) {
                if (tmpArr[j] == 0) {
                    
                    int n = 2;
                    while(j*n <= a) {
                        tmpArr[j*n] = 1;
                        n++;
                    }
                    
                }
            }

            for (int k = 3; k<tmpArr.length; k++,k++ ) {

                int operand = k;
                if (tmpArr[operand] == 1) continue;
                
                int diff  = a - operand;
                if(diff == 1 || tmpArr[diff] == 1) continue;

                System.out.println(a + " = " + operand + " + " + diff);    
                break;
            }

            // for (int k = tmpArr.length-2; k >= 2; k--) {
            //     int operand = k;

            //     if (tmpArr[operand] == 1) continue;
            //     int diff  = a - operand;
            //     if(diff == 1 || tmpArr[diff] == 1) continue;

            //     System.out.println(a + " = " + diff + " + " + operand);    
            //     break;
                
            // }
            
        
        }
        
        
    }
}
