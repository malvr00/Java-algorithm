import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, L, R));
    }

    public static long solution(final int N, final int L, final int R) {
        long[][][] dp = new long[N + 1][L + 1][R + 1];

        if(R >= 1) dp[1][1][1] = 1;

        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    // left
                    dp[n][l][r] += dp[n - 1][l - 1][r] % MOD;
                    // right
                    dp[n][l][r] += dp[n - 1][l][r - 1] % MOD;
                    // mid
                    dp[n][l][r] += (dp[n - 1][l][r] * (n - 2)) % MOD;
                }
            }
        }

        return dp[N][L][R];
    }
}