import java.util.*;

// DFS, 인접행렬, 백트래킹
public class inf0712 {
    
    int[][] graph; 
    int[] checked;
    int n;

    int answer;

    void DFS(int node) {        
        checked[node] = 1;

        if (node == 5) {
            
            checked[node] = 0;
            answer++;
        
        } else {
            for (int i = 1; i<=n; i++) {
            
                if (checked[i] != 1 && graph[node][i] == 1) {
                    DFS(i);
                    checked[node] = 0; // 스택 하나 뺄 때마다 체크를 풀어줘야함 
                }
            }
        }
    }

    // DFS 경로탐색
    public static void main(String[] args) {
        inf0712 tree = new inf0712();

        Scanner sc = new Scanner(System.in);

        tree.n = sc.nextInt(); // vertex
        int m = sc.nextInt(); // edge

        tree.graph = new int[tree.n+1][tree.n+1];
        tree.checked = new int[tree.n+1];
        
        
        for (int i = 0; i < m; i++) {
            tree.graph[sc.nextInt()][sc.nextInt()] = 1;
        }
        
        // 디버깅 용
        // for (int i = 1; i <=tree.n; i++) {
        //     for (int j=1; j<= tree.n; j++ ) {
        //         System.out.print(tree.graph[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        tree.answer = 0;

        tree.DFS(1);

        System.out.println(tree.answer);

    }
}
