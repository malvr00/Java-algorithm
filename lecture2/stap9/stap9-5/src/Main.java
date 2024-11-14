import java.util.*;

public class Main {

    public int solution(int n, int[] arr){
        int[][] dy = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (i == j) {
                    dy[j][i] = 0;
                } else if (arr[j] != arr[i]) {
                    dy[j][i] = Math.min(dy[j][i - 1], dy[j + 1][i]) + 1;
                } else if (arr[j] == arr[i]) {
                    dy[j][i] = dy[j + 1][i - 1];
                }
            }
        }

        return dy[1][n];
    }

    public int solution(int n, int[] nums, int version) {
        int[][] dy = new int[n + 1][n + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (nums[j] == nums[j + i]) {
                    dy[j][j + i] = dy[j + 1][j + i - 1];
                }  else {
                    dy[j][j + i] = Math.min(dy[j + 1][j + i], dy[j][j + i - 1]) + 1;
                }
            }
        }
        return dy[1][n];
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(main.solution(n, arr, 2));
    }
}