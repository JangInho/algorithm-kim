import java.util.Scanner;
import java.util.ArrayList;

public class inf03011 {
    
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i =0; i<n2; i++) {
            arr2[i] = sc.nextInt();
        }

        
        int i =0, j=0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while(i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                answer.add(arr1[i++]);
            } else {
                answer.add(arr2[j++]);
            }
        }

        while(i < n1) {
            answer.add(arr1[i++]);
        }

        while(j < n2) {
            answer.add(arr2[j++]);
        }

        for(int a : answer) {
            System.out.print(a + " ");   
        }

    }
}
