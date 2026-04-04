import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 누적합
// start ~ end 합 구하려면
// O(n^2) 되는 이중 for문 말고
// 처음 for문 돌 때 누적합을 저장해두는 배열을 하나 만들어두고 ex) arr[3] => 1 , 2 ,3 합
// 만약 4~6 합구하고싶으면 prefixSum[6] - prefix[3] 하면 된다
class baekjoon11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int[] prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for (int i =0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            System.out.println((prefixSum[end] - prefixSum[start-1]));
        }
        
    }

}