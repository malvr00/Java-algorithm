import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[] vals = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            vals[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, vals));

        br.close();
    }

    public static int solution(final int N, int[] vals) {
        int[][] dp = new int[N + 1][N + 1];

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;

                if (vals[i - 1] == vals[j - 1]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }

        return dp[1][N];
    }
}