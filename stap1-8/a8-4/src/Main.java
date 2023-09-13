import java.util.*;


class Node {
    int point;
    int time;
}
public class Main {
    /*
        4. 중복순열 구하기
     */

    static int[] pm;
    static int n, m;
    public static void solution(int lv, int timeSum, int pointSum, int maxTime, Node[] arr) {
        // DFS

    }

    public static void DFS(int l) {
        if (l == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                DFS(l + 1);
            }

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        DFS(0);
//        System.out.println(answer);
    }
}