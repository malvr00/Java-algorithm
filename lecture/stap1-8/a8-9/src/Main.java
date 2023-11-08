import java.util.*;

public class Main {
    /*
        9. 조합 구하기
     */

    static int[] ch;
    static int[] val;
    static int lv = 0;
    public static int solution(int n, int r) {
        if (r == lv) {
            for (int x : val) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    val[lv] = i + 1;
                    lv++;
                    solution(n, r);
                    lv--;
                    if (lv > 0) {
                        ch[i] = 0;
                    }
                }
            }
        }

        return 0;
    }

    static int[] combi;
    static int n2, m2;
    public static void DFS(int L, int s){
        if (L == m2) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n2; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int r = kb.nextInt();

        ch = new int[n];
        val = new int[r];

        n2 = n;
        m2 = r;
        combi = new int[m2];
        DFS(0, 1);

        solution(n, r);

        System.out.println();

    }
}