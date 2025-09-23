import java.util.Scanner;

// 오답
public class inf0501 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int l = 0;
        int r = 0;

        for (char a : str.toCharArray()) {
            if (a == '(')  {
                l++;
            } else {
                r++;
            }
        }

    
        System.out.println(l==r ? "YES" : "NO");
        

    }
}
