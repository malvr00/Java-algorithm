import java.util.*;

public class Main {
    /*
        11. 임시반장 정하기
     */

    public static int solution(int n, int m, int[][] arr) {
        /*
            4 3
            3 4 1 2
            4 3 2 1
            3 1 4 2
         */
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                int pi = 0;
                int pj = 0;
                for (int k = 0; k < m; k++) {
                    for (int t = 0; t < n; t++) {
                        if (i == arr[k][t]) {
                            pi = t;
                        }
                        if (j == arr[k][t]) {
                           pj = t;
                        }
                    }
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == m) {
                    result++;
                }
            }
        }

        return result;
    }

    public static int solution2(int n, int m, int[][] arr) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi = 0, pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s;
                        }
                        if (arr[k][s] == j) {
                            pj = s;
                        }
                    }
                    if(pi < pj) cnt++;
                }
                if (cnt == m) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }


        System.out.println(solution(n, m, arr));
    }
}