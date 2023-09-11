import java.util.*;

public class Main {
    /*
        1. 재귀함수
     */

    public static int solution(int n) {
        int temp = n;
        if (n == 0) {
            return 0;
        } else {
            solution(--n);
            System.out.print(temp + " ");
        }

        return temp;
    }

    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        solution(n);
    }
}