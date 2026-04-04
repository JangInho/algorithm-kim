
import java.util.*;

public class inf01101 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        String s = sc.next(); // teachermode 
        char t = sc.next().charAt(0); // e

        int[] answer = new int[s.length()];

        int p = 1000;

        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == 'e') {
                answer[i] = 0;
                p = 0;
            } else {
                answer[i] = ++p;
            }
        }

        p = Integer.MAX_VALUE;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == 'e') {
                answer[i] = 0;
                p = 0;
            } else if (answer[i] > p) {
                answer[i] = ++p;    
            }
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }

    }
}
