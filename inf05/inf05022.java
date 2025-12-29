import java.util.*;

public class inf05022 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); 
        
        Stack<Character> stack = new Stack<>();

        for (char a : str.toCharArray()) {
            
            if (a == ')') {

                while(stack.peek() != '(') {
                    stack.pop();
                }

                stack.pop();
                
            } else {
                stack.push(a);
            } 
            
        }

        StringBuilder sb = new StringBuilder();
        for (char a : stack) {
            sb.append(a);
        }

        System.out.println(sb.toString());
    }
    
}
