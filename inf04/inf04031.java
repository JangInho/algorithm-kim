import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

// two pointers & HashMap
public class inf04031 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        
        int seq = sc.nextInt();

        int[] arr = new int[cnt];

        for(int i = 0; i<cnt; i++) {
            arr[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        ArrayList<Integer> answer = new ArrayList<>();
        
        // 여기서 반복문 짤라서 가져가는 스킬 !!!!!

        for(int i = 0; i<seq; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); 
        }
        answer.add(map.size());

        for(int i= seq; i<cnt; i++) {

            if (map.get(arr[i-seq]) != null && map.get(arr[i-seq]) > 1) {
                map.put(arr[i-seq], map.remove(arr[i-seq]) - 1 );
            } else {
                map.remove(arr[i-seq]);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer.add(map.size());
        }
        
        for(int a : answer ) {
            System.out.print(a + " ");
        }
        
        
    }
}
