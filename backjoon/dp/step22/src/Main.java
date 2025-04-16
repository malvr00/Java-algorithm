import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static final int INF = 9901;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    public static long solution(final int N) {
        long[] dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] * 2) % INF;
        }

        return dp[N];
    }

    public static long solution2(final int N) {
        long[][] dp = new long[N + 1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % INF;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % INF;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % INF;
        }

        return (dp[N][0] + dp[N][1] + dp[N][2]) % INF;
    }
}