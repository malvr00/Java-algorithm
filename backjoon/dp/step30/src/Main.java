import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int W;
    private static int[][] position;
    private static int[][] dp;
    private static int[][] choice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        position = new int[W + 1][2];

        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    public static void solution() {
        dp = new int[W + 1][W + 1];
        choice = new int[W + 1][W + 1];

        for(int i = 0; i <= W; i++) Arrays.fill(dp[i], -1);

        int cnt = backtracking(0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");

        int a = 0, b = 0;
        for (int i = 1; i <= W; i++) {
            int k = choice[a][b];
            sb.append(k).append("\n");
            if(k == 1) a = i;
            else b = i;
        }

        System.out.println(sb);
    }

    public static int backtracking(int a, int b) {
        int next = Math.max(a, b) + 1;

        if(next > W) return 0;
        if(dp[a][b] != -1) return dp[a][b];

        int costA = score(a, next, true) + backtracking(next, b);
        int costB = score(b, next, false) + backtracking(a, next);

        if (costA <= costB) {
            dp[a][b] = costA;
            choice[a][b] = 1;
        } else {
            dp[a][b] = costB;
            choice[a][b] = 2;
        }

        return dp[a][b];
    }

    public static int score(int from, int to, boolean check) {
        int x, y;
        if (from == 0) {
            if (check) { x = 1; y = 1; }
            else { x = N; y = N; }
        } else {
            x = position[from][0];
            y = position[from][1];
        }

        return Math.abs(x - position[to][0]) + Math.abs(y - position[to][1]);
    }
}