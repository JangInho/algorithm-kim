import java.util.*;

// 재귀함수로 1부터 출력해라 
public class inf0701 {
    

    // 이 재귀함수 if-else 틀은 외워라
    static void DFS(int num) {

        if (num == 0){
            return;
        } else {
            System.out.println(num); // 3 2 1 ...
            DFS(num-1);
            // System.out.println(num); // 1 2 3 ...
        }
    } 
        

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        DFS(num);
        
    }
}
