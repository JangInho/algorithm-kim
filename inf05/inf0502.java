import java.util.Scanner;
import java.util.Stack;

public class inf0502 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        Stack<Character> stack = new Stack<>();

        for(char a : str.toCharArray()) {
            if (a != ')') {
                stack.push(a);
            } else if (a == ')') {
                // while (stack.peek() != '(') {
                //     stack.pop();
                // } 
                // if (stack.peek() == '(') {
                //     stack.pop();
                // }

                // pop을 사용한 반복문 사용
                while (stack.pop() != '(') {
                
                } 
                
            }
        }

        for (char a : stack) {
            System.out.print(a);
        }
        
    }

}
