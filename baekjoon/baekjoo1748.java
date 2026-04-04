import java.util.*;



public class baekjoo1748 {
    
    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        
        // 1~9 - 1 - 9 
        // 10~99 - 2 - 90
        // 100~999 - 3 - 900 
        // 1000~9999 - 4 - 9000
        // 10000 ~ 99999 - 5 - 90000

        // 120
        // 252
        
        // 120 % 10 = 0
        // 120 % 100 = 20
        // 120   1000 = 120 
        
        // 1 2 3 ---- 9 -> 9개
        // 10 ------ 99 -> 90 -> 180 
        // 100 ----- 20 -> 21 -> 63
        // 100 ----- 999 -> 900
        
        int answer = 0;
        int nine = 9;
        

        for (int i = 1; i <= String.valueOf(n).length(); i++) {
        
            if (i == String.valueOf(n).length()) {
                
                int mul = 1;
                for (int k = 0; k<i-1; k++){
                    mul *= 10;
                }
                
                answer += i * ((n - mul) + 1);
            } else {
                answer += i * (nine); 
            }

            nine *= 10;
            
        }

        System.out.println(answer);





    }


}
