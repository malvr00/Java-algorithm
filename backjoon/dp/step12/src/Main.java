import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, values));
    }

    public static int solution(final int N, int[] values) {
        if(N == 1) return 1;

        Arrays.sort(values);

        // 1 3 4 5 7
        int answer = 0;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int cnt = 2;
                int rule = values[j - 1] - values[i - 1];
                for (int k = i - 1; k > 0; k--) {
                    if (values[i - 1] - values[k - 1] == rule) {
                        cnt = Math.max(dp[k][i] + 1, cnt);
                        break;
                    }
                }
                dp[i][j] = cnt;
                answer = Math.max(dp[i][j], answer);
            }
        }

        return answer;
    }
}