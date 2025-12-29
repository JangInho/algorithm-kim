import java.util.*;

public class inf04111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt();

        String candidate = sc.next();

        HashMap<Character, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        char maxChar = ' ';
        
        for (char a : candidate.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for (char a : map.keySet()) {
            if (max < map.get(a)) {
                max = map.get(a);
                maxChar = a;
            }
        }

        System.out.println(maxChar);
    }
}