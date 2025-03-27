import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());

        long[] answer = new long[K];
        for (int i = 0; i < K; i++) {
            answer[i] = solution(Integer.parseInt(br.readLine()));
        }

        for (long temp : answer) {
            System.out.println(temp);
        }
    }

    public static long solution(final int N) {
        if(N < 4) return 1;

        long[] dp = new long[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;


        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 3] + dp[i - 2];
        }

        return dp[N];
    }
}