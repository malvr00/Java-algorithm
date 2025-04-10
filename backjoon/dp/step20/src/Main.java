import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }

    public static long solution(final int N, final int K) {
        long[][] dp = new long[K + 1][N + 1];

        for(int i = 1; i <= K; i++) dp[i][0] = 1;
        for(int i = 1; i <= N; i++) dp[1][i] = 1;

        for (int k = 2; k <= K; k++) {
            for (int n = 1; n <= N; n++) {
                dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % INF;
            }
        }

        return dp[K][N];
    }
}