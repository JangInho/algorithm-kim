import java.util.*;

class baekjoon1977 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
                
        for (int i = m; i<=n; i++) {
            long r = (long)Math.sqrt((long)i);
            if (r * r == i) arr.add(i);
        }
        
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        } 

        System.out.println(sum);
        System.out.println(arr.get(0));
        
    }
    
}