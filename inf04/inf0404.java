import java.util.Scanner;
import java.util.HashMap;

// 마지막 테스트 통과 못함
public class inf0404 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] strArr = str.toCharArray();

        String ana = sc.next();
        char[] anaArr = ana.toCharArray();
        int anaLength = ana.length();
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        int answer = 0;

        for (int i=0; i< anaLength; i++) {
            map2.put(strArr[i], map2.getOrDefault(strArr[i], 0));
            map1.put(anaArr[i], map1.getOrDefault(anaArr[i], 0));   
        }

        if (map1.keySet().equals(map2.keySet())) {
            answer++;
        }

        int lt = 0;        
        for (int rt = anaLength; rt <strArr.length; rt++) {

            if (map2.containsKey(strArr[lt])) {
                int val = map2.get(strArr[lt]);
                if (val > 0) {
                    map2.put(strArr[lt], val - 1);
                } else {
                    map2.remove(strArr[lt]);
                }
            }

            lt++;

            map2.put(strArr[rt], map2.getOrDefault(strArr[rt], -1) + 1);

            if (map1.keySet().equals(map2.keySet())) {
                answer++;
            }

        }

        System.out.println(answer);
   
    }
}
