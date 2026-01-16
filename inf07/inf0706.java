

// 부분집합 구하기 왜 결과가 다르지;;
public class Inf0706 {
    
    static int n;
    static int[] ch;
    
    static void DFS(int l) {

        if (l == n+1) {

            String tmp = "";
            for (int i =1; i<=n; i++) {
                if (ch[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }

            return;
        } else {
            ch[l] = 1;
            DFS(n+1);
            ch[l] = 0;
            DFS(n+1);
        }
        
    
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1];
        DFS(1);
    }

}
