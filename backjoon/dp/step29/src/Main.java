import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] moves;
    private static int[][][] dp;
    private static int CNT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int openA = Integer.parseInt(st.nextToken());
        int openB = Integer.parseInt(st.nextToken());

        final int cnt = Integer.parseInt(br.readLine());
        int[] move = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            move[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, openA, openB, move));
    }

    public static int solution(final int N, int openA, int openB, int[] move) {
        CNT = move.length;
        moves = move;
        dp = new int[CNT][N + 1][N + 1];

        for (int i = 0; i < CNT; i++) {
            for (int a = 0; a <= N; a++) {
                Arrays.fill(dp[i][a], -1);
            }
        }

        return dfs(0, openA, openB);
    }

    public static int dfs(int idx, int a, int b) {
        if(idx == CNT) return 0;

        int val = moves[idx];
        int tempA = Math.min(a, b);
        int tempB = Math.max(a, b);

        if(dp[idx][tempA][tempB] != -1) return dp[idx][tempA][tempB];

        int costA = Math.abs(val - tempA) + dfs(idx + 1, val, tempB);
        int costB = Math.abs(val - tempB) + dfs(idx + 1, tempA, val);

        return dp[idx][tempA][tempB] = Math.min(costA, costB);
    }

}