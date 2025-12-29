import java.util.*;

public class inf05013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        String str  = sc.next(); 

        Stack<Character> stack = new Stack<>();

        for (char a : str.toCharArray()) {
            if (a == '(') {
                stack.push(a);
            } else if (stack.peek() == '(') {
                stack.pop();
            }            
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }

}
