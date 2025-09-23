import java.util.Scanner;
import java.util.Stack;

public class inf0502 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        
        for (char a : str.toCharArray()) {
            if (a == '(')  {
                stack.push(a);      
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        
    }
}
