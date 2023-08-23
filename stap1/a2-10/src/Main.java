import java.util.*;

public class Main {
    /*
        10. 봉우리
     */

    public static int solution(int n, int[][] arr) {
        int result = 0;

        for (int i = 1; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 1; j < n - 1; j++) {
                int upVal = arr[i - 1][j];
                int downVal = arr[i + 1][j];
                int rightVal = arr[i][j + 1];
                int leftVal = arr[i][j - 1];
                int original = arr[i][j];

                if (upVal < original && downVal < original && rightVal < original && leftVal < original) {
                    flag = true;
                } else {
                    flag = false;
                }
                if (flag) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int solution2(int n, int[][] arr) {
        int result = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt() + 2;
        int[][] arr = new int[n][n];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                arr[i][j] = kb.nextInt();
            }
        }


        System.out.println(solution(n, arr));
    }
}