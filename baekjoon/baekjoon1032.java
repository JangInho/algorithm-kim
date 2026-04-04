import java.util.*;

public class baekjoon1032 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];

        for(int i =0; i<n; i++) {
            arr[i] = sc.next();
        }

        int length =  arr[0].length();

        String answer = "";

        for(int i = 0; i < length; i++) {

            boolean isEquals = true;

            char tmp = arr[0].charAt(i);
            
            for (int j=0; j<n; j++) {
                if (tmp != arr[j].charAt(i)) isEquals = false;
                tmp = arr[j].charAt(i);
            }

            if(isEquals) {
                answer += tmp;
            } else {
                answer += "?";
            }
            
        }

        System.out.println(answer);
        
    }
}
