package inf01;

import java.util.Scanner;

public class inf01011 {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toUpperCase();

        char c = sc.next().charAt(0);
        
        c = Character.toUpperCase(c);

        int count = 0;

        for (char a : str.toCharArray()) {
            if (a == c) {
                count++;
            }
        }

        System.out.println(count);

        return;
        
    }

}
