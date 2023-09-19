import java.util.*;

public class Main {
    /*
        8. 수열 추측하기
     */

    static int lv = 0;
    static int[] ch;
    static int[] out;
    static boolean flag = false;
    public static int[] solution(int n, int r) {
        if (lv == n) {
            int[] sum = out.clone();
            for (int i = 0; i < lv; i++) {
                for (int j = 0; j < lv - 1 - i; j++) {
                    sum[j] = sum[j] + sum[j + 1];
                }
            }
            if (sum[0] == r) {
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if(flag) return out;
                if (ch[i] == 0) {
                    ch[i] = 1;
                    out[lv] = i;
                    lv++;
                    solution(n, r);
                    ch[i] = 0;
                    lv--;
                }
            }
        }
        return out;
    }


    static int[] b, p, ch2;
    static int n2, f;
    static boolean flag2 = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if(dy[n][r] > 0) return dy[n][r];
        if (n == r || n == 0) {
            return 1;
        } else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public static void DFS(int L, int sum){
        if(flag) return;
        if (L == n2) {
            if (sum == f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag2 = true;
            }
        } else {
            for (int i = 1; i <= n2; i++) {
                if (ch2[i] == 0) {
                    ch2[i] = 1;
                    p[L] = i;
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch2[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int r = kb.nextInt();
        ch = new int[n + 1];
        out = new int[n];
        int[] ans = solution(n, r);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        // 방법 2
        n2 = n;
        f = r;
        b = new int[n];
        p = new int[n];
        ch2 = new int[n+1];
        for (int i = 0; i < n; i++) {
            b[i] = T.combi(n - 1, i);
        }
        DFS(0, 0);


        System.out.println();

    }
}