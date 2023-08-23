import java.util.*;

public class Main {
    /*
        9. 격자판 최대합
     */

    public static int solution(int n, int[][] arr) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int val1 = 0;
            int val2 = 0;
            int val3 = 0;
            for (int j = 0; j < n; j++) {
                val1 += arr[i][j];
            }
            for (int j = 0; j < n; j++) {
                val2 += arr[j][i];
            }

            if (val1 > val2) {
                val3 = val1;
            } else {
                val3 = val2;
            }
            if (result < val3) {
                result = val3;
            }
        }

        int val = 0;
        for (int i = 0; i < n; i++) {
            val += arr[i][i];

            if (result < val) {
                result = val;
            }
        }

        val = 0;
        for (int i = n - 1; i >= 0; i--) {
            val += arr[i][i];

            if (result < val) {
                result = val;
            }
        }

        return result;
    }

    public static int solution2(int n, int[][] arr) {
        int result = 0;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }

            result = Math.max(result, sum1);
            result = Math.max(result, sum2);
        }
        sum1=sum2=0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        result = Math.max(result, sum1);
        result = Math.max(result, sum2);

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] =kb.nextInt();
            }
        }


        System.out.println(solution(n, arr));
    }
}