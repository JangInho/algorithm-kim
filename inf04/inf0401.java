import java.util.*;

public class inf0401 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String input = sc.next();
        char[] arr = input.toCharArray();

        int[] alphabetArr = new int[5];
        
        for (int i = 0; i<n ; i++) {
            switch (arr[i]) {
                case 'A':
                    alphabetArr[0]++;
                    break;
                case 'B':
                    alphabetArr[1]++;
                    break;
                case 'C':
                alphabetArr[2]++;
                    break;
                case 'D':
                alphabetArr[3]++;
                    break;
                case 'E':
                alphabetArr[4]++;
                    break;
            
                default:
                    break;
            }
        }

        int tmp = Integer.MIN_VALUE;
        int answerIndex = 0;
        for ( int i = 0; i<5; i++) {
            if (alphabetArr[i] > tmp) {
                tmp = alphabetArr[i];
                answerIndex = i;
            }
        }
        
        switch (answerIndex) {
            case 0:
                System.out.println("A");
                break;
            case 1:
            System.out.println("B");
                break;
            case 2:
            System.out.println("C");
                break;
            case 3:
            System.out.println("D");
                break;
            case 4:
            System.out.println("E");
                break;
        
            default:
            System.out.println("default");
                break;
        }
        
    }
}
