import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[][] values = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            values[i][0] = Integer.parseInt(st.nextToken());
            values[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, values));
    }

    public static long solution(int N, int[][] values) {
        long[] ps = new long[N + 1];
        ps[0] = values[0][0];
        ps[1] = values[0][1];

        for (int i = 2; i <= N; i++) {
            ps[i] = values[i - 1][1];
        }

        long[][] dp = new long[N + 1][N + 1];

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                long value = Long.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long cost = dp[i][k] + dp[k + 1][j] + ps[i - 1] * ps[k] * ps[j];
                    if(cost < value) value = cost;
                }
                dp[i][j] = value;
            }
        }

        return dp[1][N];
    }
}