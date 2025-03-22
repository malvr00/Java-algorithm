import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            final int K = Integer.parseInt(br.readLine());

            int[][] board = new int[2][K];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int z = 0; z < K; z++) {
                    board[j][z] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(solution(N, K, board)).append("\n");
        }

        System.out.print(sb);
    }

    public static int solution(int N, int K, int[][] board) {
        // [i] = 0: 위, 1: 아래, 2: 선택안함
        int[][] dp = new int[3][K];

        dp[0][0] = board[0][0];
        dp[1][0] = board[1][0];
        dp[2][0] = 0;

        for (int i = 1; i < K; i++) {
            dp[0][i] = Math.max(dp[2][i - 1], dp[1][i - 1]) + board[0][i];
            dp[1][i] = Math.max(dp[2][i - 1], dp[0][i - 1]) + board[1][i];
            dp[2][i] = Math.max(dp[2][i - 1], Math.max(dp[0][i - 1], dp[1][i - 1]));
        }

        return Math.max(dp[0][K - 1], Math.max(dp[1][K - 1], dp[2][K - 1]));
    }
}