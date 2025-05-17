import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private final static int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    public static long solution(final int N) {
        long[] dp = new long[N + 1];

        if(N <= 1) return 0;

        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((i - 1) * (dp[i - 2] + dp[i - 1])) % MOD;
        }

        return dp[N];
    }

}