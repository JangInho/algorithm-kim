import java.util.*;

public class inf06011 {
    

    // 선택 정렬
    // 배열에서 가장 앞에 있는 것부터 그 뒤에서 가장 작은거 가져와서 자리 바꾸는 정렬 방식
    // 그리고 한칸씩 옮겨서 계속 반복
    // 비교할 때는 arr[i] 를 사용하는게 핵심 Integer.MIN_VALUES 쓰지말고

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i =0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i<n; i++) {
            
            int min = arr[i];
            int idx = i;

            for (int j =i+1; j<n; j++) {
                
                if (arr[j] < min) {  
                    min = arr[j];
                    idx = j;
                }

            }

            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            
        }
        
        for (int a : arr) {
            System.out.print(a + " ");
        }
        
    }
}



