import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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

        solution(coins, K);
    }

    public static void solution(final int[] coins, final int K) {
        int[] dp = new int[K + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = coin; j <= K; j++) {
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[K]);
    }
}