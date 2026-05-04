import java.util.*;

class Point implements Comparable<Point> {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        // this -> o 순으로 오름차순이 되게 하려면 음수가 리턴되게 해야한다
        // 그래서 앞에서 뒤에껄 빼고
        // this -> o 순으로 내림차순이 되게하려면 음수가 리턴되게 해야하는데
        // 뒤에서 앞에껄 빼야한다
        // 이건 외우라!
        if (this.x == o.x) return o.y - this.y; 
        else {
            return this.x - o.x;
        }
    }    
}

public class inf0607 {
    
    // 좌표 정렬
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        ArrayList<Point> arr = new ArrayList<>();

        int n = sc.nextInt();

        for(int i =0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for(Point o : arr) System.out.println(o.x + " , " + o.y);

    }
}
