import java.util.Scanner;
import java.util.Stack;

public class inf05011 {
    
    public static void main(String args[]) {

        
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        
        Stack<Character> st =  new Stack<>();
        
        for(char a : str.toCharArray()) {

            if (a == '(') {
                st.add(a);
            } else {
                if (!st.isEmpty()) {
                    st.pop();    
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        if (st.isEmpty()) {
            System.out.println("YES");
            return;
        } else {
            System.out.println("NO");
            return;
        }
        
    }

}
