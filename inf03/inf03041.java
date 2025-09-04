import java.util.Scanner;

public class inf03041 {
    
    public static void main(String args[]) {

        
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int targetSum = sc.nextInt();
        int[] arr = new int[cnt];

        for(int i =0; i < cnt; i++ ) {
            arr[i] = sc.nextInt();
        }


        int lt =0, rt=0;
        int sum = 0;

        int answer = 0;

        sum = arr[0];

        if ( sum == targetSum) {
            answer++;
        }

        for (int i =0; i< cnt; i++) {
            
            if ( sum == targetSum) {
                answer++; 
                sum -= arr[lt];
                lt++;
                rt++;
                sum += arr[rt];
            } else if(sum < targetSum) {
                rt++;
                sum += arr[rt];
            } else if (sum > targetSum) {
                sum -= arr[lt];
                lt++;
            }

        }

        System.out.println(answer);

        

    }
}
