import java.util.*;

public class Main {
    /*
        11. 임시반장 정하기
     */

    public static int solution(int n, int[][] arr) {
        int result = 0;
        int[] total = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            List<Integer> sch = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                int mClass = arr[i][j];
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    int nClass = arr[k][j];
                    if (mClass == nClass) {
                        if (sch.indexOf(k) == -1) {
                            sch.add(k);
                            count++;
                        }
                    }
                }
            }
            total[i] = count;
        }

        for (int i = 1; i < total.length; i++) {
            int tmp = total[0];
            if (total[0] < total[i]) {
                total[0] = total[i];
                total[i] = tmp;
                result = i;
            }
        }

        return result + 1;
    }

    public static int solution2(int n, int[][] arr) {
        int result = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                result = i;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][5]; // solution2 = [n + 1][6], for i,j = 1, i,j <= 5

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }


        System.out.println(solution(n, arr));
    }
}