import java.util.*;

public class Main {

    /*
        1. 계단 오르기
     */

    static int answer = 0;
    static int max;
    public static void myDFS(int sum) {
        if (sum >= max) {
            if (sum == max) {
                answer++;
            }
        } else {
            myDFS(sum + 1);
            myDFS(sum + 2);
        }

    }

    static int[] dy;
    public static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= max; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[max];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        max = kb.nextInt();
        myDFS(0);

        dy = new int[max + 1];

        System.out.println(answer);
    }
}