import java.util.*;

public class inf0402 {
    
    public static  void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        HashMap<Character, Integer> map1 = new HashMap<>();
        String str2 = sc.next();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (char a : str1.toCharArray()) {
            map1.put(a, map1.getOrDefault(a, 0)+1);
        }
        
        for (char a : str2.toCharArray()) {
            map2.put(a, map2.getOrDefault(a, 0)+1);
        }

        boolean isAnagram = true;
        for(char a : map1.keySet()) {
            if (!map2.containsKey(a) || map2.get(a) != map1.get(a) ) {
                isAnagram = false; 
            }
        }

        for(char a : map2.keySet()) {
            if (!map1.containsKey(a) || map2.get(a) != map1.get(a)) {
                isAnagram = false; 
            }
        }

        if(isAnagram) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
            
    }
}
