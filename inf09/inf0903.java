package inf09;

import java.util.*;

public class inf0903 {

    static int n;
    static int m;
    
    static int[] score;
    static int[] point;

    static int[] ch;

    static int max = 0;

    public static void DFS(int i) {
        
        if (i == n+1) {

            int scoreSum = 0;
            int pointSum = 0;
            
            for (int k = 1; k<n+1; k++) {
                if (ch[k] == 1) {
                    scoreSum += score[k];
                    pointSum += point[k];        
                }
            }
            
            if (pointSum <= m && scoreSum > max) {
                max = scoreSum;
            }

        } else {

            ch[i] = 1;
            DFS(i+1);

            ch[i] = 0;
            DFS(i+1);
            
        }
        
    } 
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        score = new int[n+1];
        point = new int[n+1];

        ch = new int[n+1];

        for (int i = 1; i<n+1; i++) {
            
            score[i] = sc.nextInt();
            point[i] = sc.nextInt();
        }

        DFS(1);
        System.out.println(max);
    }
    
}
