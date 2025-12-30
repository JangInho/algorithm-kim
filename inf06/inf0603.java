
import java.util.Scanner;


public class inf0603 {

    // 삽입 정렬
    // j번째 arr값을 뒤로 계속 밀면서 i번째의 arr값의 제자리를 찾아주는 알고리즘임
    // 모르겠으면 강의 그림을 보라
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ; i< n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i =1; i< n; i ++) {
            int tmp = arr[i];
            int j;
            for (j=i-1; j>= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = tmp;
        }

        for (int a : arr) {
            System.out.print(a + " ");
        }

         
    }
}
