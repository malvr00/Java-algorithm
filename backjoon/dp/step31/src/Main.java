import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, score));
    }

    public static int solution(final int N, int[] score) {
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int minA = score[i - 1], maxB = score[i - 1];
            for (int j = i; j >= 1; j--) {
                minA = Math.min(score[j - 1], minA);
                maxB = Math.max(score[j - 1], maxB);

                dp[i] = Math.max(dp[i], maxB - minA + dp[j - 1]);
            }
        }

        return dp[N];
    }
}