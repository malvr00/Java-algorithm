import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(board));
    }

    public static long solution(int[][] board) {
        final int N = board.length;

        long[][] dp = new long[N][N];

        dp[0][0] = 1;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(dp[x][y] == 0) continue;

                int cost = board[x][y];
                if(cost == 0) continue;

                int r = x + cost;
                int c = y + cost;

                if(r < N) dp[r][y] += dp[x][y];
                if(c < N) dp[x][c] += dp[x][y];
            }
        }

        return dp[N - 1][N - 1];
    }

}