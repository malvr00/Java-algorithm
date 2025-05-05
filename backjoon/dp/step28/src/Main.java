import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long ENF = Long.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, M, scores));
    }

    public static long solution(final int N, final int M, int[] scores) {
        long[][] dp = new long[N + 1][M + 1];

        long[] sums = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sums[i] += sums[i - 1] + scores[i - 1];
            Arrays.fill(dp[i], ENF);
            dp[i][0] = 0;
        }
        Arrays.fill(dp[0], ENF);
        dp[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];

                for (int k = 1; k <= i; k++) {
                    long val;
                    if (k - 2 >= 0) {
                        val = dp[k - 2][j - 1];
                    } else {
                        val = j - 1 == 0 ? 0 : ENF;
                    }

                    if(val == ENF) continue;

                    dp[i][j] = Math.max(dp[i][j], val + sums[i] - sums[k - 1]);
                }
            }
        }

        return dp[N][M];
    }
}