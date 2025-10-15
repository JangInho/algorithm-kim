import java.util.Scanner;
import java.util.HashMap;

public class inf04012 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char a : str.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        int max = Integer.MIN_VALUE;        
        char answer = ' ';
        for (char a : map.keySet()) {
        
            if (map.get(a) > max) {
                max = map.get(a);
                answer = a;
            }
        }

        System.out.println(answer);
        
        
        
    }
}
