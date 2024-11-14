import java.io.*;
import java.util.*;

public class Main {

    public int solution(int n, int[] nums) {
        int[][] dy = new int[n + 1][n + 1];

        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            dy[i][i] = nums[i];
            sumMap.put(i, sumMap.getOrDefault(i - 1, 0) + nums[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                int left = dy[j][j + i - 1];
                int bottom = dy[j + 1][j + i];
                int base = sumMap.get(j + i) - sumMap.getOrDefault(j - 1, 0);
                dy[j][j + i] = Math.max(left, bottom) + base;
            }
        }

        return dy[1][n];
    }
    public static void main(String[] args) throws IOException {
        // 5 1 3 1 5 2
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(main.solution(n, nums));

        br.close();
    }
}