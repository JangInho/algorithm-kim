import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class inf0405 {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] intArr = new int[n];

        if (k > n) {
            System.out.println(-1);
            return;
        }

        for (int i =0; i<n; i++) {
            intArr[i] = sc.nextInt();   
        }


        int first =0, second = 0, third=0; 

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            first = intArr[i];

            for (int j=i+1; j<n; j++) {
                second = intArr[j];

                for (int l = j+1; l<n; l++ ) {
                    third = intArr[l];

                    map.put(first+second+third, map.getOrDefault(first+second+third, 0)+1);
                }
            }
        }

        // for (int a : map.keySet()) {
        //     System.out.println(a);
        // }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.reverseOrder());
        
        // System.out.println(list);

        System.out.println(list.get(k-1));
    }
}
