import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class inf0302 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int cnt1 = sc.nextInt();
        int[] arr1 = new int[cnt1];
        for(int i= 0; i<cnt1; i++) {
            arr1[i] = sc.nextInt();
        }

        int cnt2 = sc.nextInt();
        int[] arr2 = new int[cnt2];
        for(int i= 0; i<cnt2; i++) {
            arr2[i] = sc.nextInt();
        }

        
        
        ArrayList<Integer> answer = new ArrayList<>();

        // two pointers 버전
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i =0, j =0;
        while (i < cnt1 && j < cnt2) {

            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] == arr2[j]) {
                answer.add(arr1[i]);
                i++; 
                j++;
            } else {
                j++;
            }
            
        }

        for(int a : answer) {
            System.out.print(a + " ");
        }
        
        // 이중 for 문 실패버전 -> 특정 경우 Runtime error -> 오타였음;; -> 근데 시간 초과
        // for (int i=0; i<cnt1; i++) {
        //     for(int j=0; j<cnt2; j++) {
        //         if (arr1[i] == arr2[j]) {
        //             answer.add(arr1[i]);
        //         }
        //     }
        // }

        // answer.add(1000000001);
        

        // for (int k =0; k < answer.size()-1; k++) {
        //     for (int i =0; i < answer.size()-1; i++) {
        //         if (answer.get(i+1) < answer.get(i)) {
        //             int tmp = answer.get(i);
        //             answer.set(i, answer.get(i+1));
        //             answer.set(i+1, tmp);
        //         }
        //     }
        // }
    

        // for (int i = 0; i< answer.size() -1 ; i++) {
        //     System.out.print(answer.get(i) + " ");
        // }
        
    }
}
