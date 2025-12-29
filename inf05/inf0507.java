import java.util.*;

public class inf0507 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        
        String targerStr = sc.nextLine();
        char[] targetCharArr = targerStr.toCharArray();
        
        String inputStr = sc.nextLine();
        char[] inputCharArr = inputStr.toCharArray();

        for (char a : targetCharArr) {
            st1.push(a);
        }

        for (char a : inputCharArr) {
            st2.push(a);
        }

        int st2Length = st2.size();


        // 반복문 안에서 렝스로 사용하는 배열이나 이터레이터의 길이를 조절하지 말 것.
        for(int i =0; i< st2Length; i++) {
            if (st2.pop() == st1.peek()) {
                st1.pop();
            }
        }

        if (st1.isEmpty()) {
            
            System.out.println("YES");
        } else {
            
            System.out.println("NO");
        }

        
    }
}
