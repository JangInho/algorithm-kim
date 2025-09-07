import java.util.*;

// Time limit
public class inf0403 {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int seq = sc.nextInt();
        int[] arr = new int[cnt];
        
        for (int i=0; i<cnt; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i<cnt-(seq-1); i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j=i; j<i+seq; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) +1);
            }
            ans.add(map.size());
        }
        
        for (int a : ans) {
            System.out.print(a + " ");
        }

        
        
    }
}
