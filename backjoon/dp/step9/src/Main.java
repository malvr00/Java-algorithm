import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            final int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] files = new int[size + 1];
            for (int j = 1; j <= size; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }
            list.add(files);
        }

        for (int[] files : list) {
            System.out.println(solution(files.length - 1, files));
        }
    }

    public static long solution(int K, int[] files) {
        long[] ps = new long[K + 1];
        for (int i = 1; i <= K; i++) ps[i] = ps[i - 1] + files[i];

        long[][] dp = new long[K + 2][K + 2];

        for (int len = 2; len <= K; len++) {
            for (int i = 1; i + len - 1 <= K; i++) {
                int j = i + len - 1;
                long best = Long.MAX_VALUE;
                long sum = ps[j] - ps[i - 1];
                for (int k = i; k < j; k++) {
                    long cand = dp[i][k] + dp[k + 1][j] + sum;
                    if (cand < best) best = cand;
                }
                dp[i][j] = best;
            }
        }
        return dp[1][K];
    }
}