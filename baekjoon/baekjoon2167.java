import java.util.*;

class baekjoon2167 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        ArrayList<Integer> answer = new ArrayList<>();
        int sum = 0;
        
        for (int l = 0; l<k; l++) {
            int i = sc.nextInt() -1;
            int j = sc.nextInt() -1;
            int x = sc.nextInt() -1;
            int y = sc.nextInt() -1;

            for (int o = i; o <= x; o++) {
                for (int p = j; p <= y; p++) {
                    sum += arr[o][p];
                }   
            }
            answer.add(sum);
            sum = 0;
        }

        for (int a : answer) {
            System.out.println(a);
        }
        
    
    }
}