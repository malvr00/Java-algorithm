import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        Set<Integer> vip = new HashSet<>();
        for (int i = 0; i < M; i++) {
            vip.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(solution(N, vip));
        test();
    }

    public static int solution(final int N, final Set<Integer> vip) {
        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (vip.contains(i) || vip.contains(i - 1)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }

        return dp[N];
    }

    public static void test() {
        final int N = 9;
        final int M = 2;
        int[] vip = {4, 7};
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long ans = 1;
        int prev = 0;

        for (int i = 0; i < M; i++) {
            int cur = vip[i];
            int len = cur - prev - 1;
            ans *= dp[len];
            prev = cur;
        }

        int len = N - prev;
        ans *= dp[len];

        System.out.println(ans);
    }
}