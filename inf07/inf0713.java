import java.util.*;

class inf0713 {
    
    ArrayList<ArrayList<Integer>> list;
    int n;
    int[] checked;
    int answer;
    

    void DFS(int node) {

        checked[node] = 1;

        if (node == 5) {
            checked[node] = 0;
            answer++;
        } else {

            // for each 문으로도 가능하다 ! for (ArrayList<>)
            // for (int a : list.get(node)) {
            // }
            
            for (int i = 1; i <= n; i++ ) {
                if (list.get(node).contains(i) && checked[i] != 1) {
                    DFS(i);
                    checked[i] = 0;
                }
            }
        }
        
    }

    public static void main(String[] argsr) {
        
        Scanner sc = new Scanner(System.in);
        inf0713 main = new inf0713();  
        main.answer = 0;

        main.n = sc.nextInt(); // node, vertex
        int m = sc.nextInt(); // edge

        main.checked = new int[main.n+1];

        main.list = new ArrayList<>();

        for (int i = 0; i<=main.n; i++) {
            main.list.add(new ArrayList<Integer>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            main.list.get(a).add(b);
        }
        
        main.DFS(1);

        System.out.println(main.answer);
    }
}