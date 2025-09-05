import java.util.HashMap;
import java.util.*;

// 해쉬맵
public class inf04011 {
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        
        int cnt = sc.nextInt();

        String str = sc.next(); // nextInt를 사용하면 줄바꿈은 안읽으니까 남아있는 줄바꿈을 한문장이라고 인식해서 nextLine이 읽어버림 next()는 공백기준으로 읽고 줄바꿈은 버림
        
        int max = Integer.MIN_VALUE;
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char a : str.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        for (char a : map.keySet()) {
            if (max < map.get(a)) {
                max = map.get(a);
                answer = a;
            }
        }

        System.out.println(answer);
    }
}
