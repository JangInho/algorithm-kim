import java.io.*;
import java.util.*;

public class inf0609 {

    // 결정알고리즘 --> 다시 풀어보자 이거 틀린거임
    // minArr 새로운 배열을 생성하지 않아도 풀 수 있음
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i =0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // 결정알고리즘에는 이분검색이 쓰이니까 정렬해줌
        Arrays.sort(arr);

        // int max = arr[arr.length-1];

        // for (int a : arr) {
        //     sum += a;
        // }

        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();

        int[] minArr = new int[sum - max+1];
        for (int i = 0; i < minArr.length; i++) {
            minArr[i] = max + i;
        }

        int answer = 0;
        int lt, rt, mid;
        lt = 0; 
        rt = minArr.length-1;
        
        while (lt <= rt) {
            mid = (lt + rt) / 2;
            int setCount = getSetCount(arr, minArr[mid]);

            System.out.println(setCount);
            
            if (setCount == m) {
                answer = arr[mid];
                rt = mid -1;
            } else if (setCount < m) {
                rt = mid -1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
        
        
    }

    static int getSetCount(int[] arr, int min) {
        
        int count = 1;
        int sum = 0;
        for (int a : arr) {
            sum += a;
            if (sum > min) {
                count++;
                sum = a;
            }
        }
        return count;
    }

    
}
