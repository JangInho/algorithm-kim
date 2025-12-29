import java.util.Scanner;

public class inf02111 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);


        int stuCount = sc.nextInt();

        int[][] classArrays = new int[stuCount][5];

        
        for (int i =0; i<stuCount; i++) {
            for (int j =0; j<5; j++) {
                classArrays[i][j] = sc.nextInt();
            }
        }
        
        
        int[] nums = new int[stuCount];

        for (int i = 0; i<stuCount; i++) {
            for (int j=0; j<5; j++ ) {
                for (int k=0; k<stuCount; k++) {
                    if (classArrays[i][j] == classArrays[k][j]) {
                        nums[i]++;
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int targetIndex = Integer.MIN_VALUE;
        for (int i = 0; i<stuCount; i++) {
            if (max < nums[i]) {
                max = nums[i];
                targetIndex = i;
            }
        }

        System.out.println(targetIndex + 1);

    }

    
}
