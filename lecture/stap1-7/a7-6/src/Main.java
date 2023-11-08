import java.util.*;

public class Main {
    /*
        6. 부분집합 구하기(DFS)
     */

    static int n;
    static int[] ch;

    public static void solution(int n) {

    }

    public static void DFS(int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
                if (tmp.length() > 0) {
                    System.out.println(tmp);
                }
            }
        } else {
            ch[l] = 1;
            DFS(l + 1);
            ch[l] = 0;
            DFS(l + 1);
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n + 1];
        DFS(1);
    }
}