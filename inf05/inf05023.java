import java.util.*;

public class inf05023 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> st = new Stack<>();

        for (char a : str.toCharArray()) {
            if (a != ')') {
                st.push(a);
            } else {
                while(st.pop() != '(') {}
            }
        }

        for (char a : st) {
            System.out.print(a + " ");
        }
        
    }
}
