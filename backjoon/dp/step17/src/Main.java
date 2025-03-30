import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(coins, K));
    }

    private static int solution(final int[] coins, final int K) {
        int[] dp = new int[K + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= K; i++) {
                if(dp[i - coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[K] == Integer.MAX_VALUE ? -1 : dp[K];
    }

}