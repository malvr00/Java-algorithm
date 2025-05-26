import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int answer = 1;
    private static int[][] board;
    private static int N;
    private static int M;
    private static final int MOVE_CNT = 4;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int j = 0;
            for (char c : s.toCharArray()) {
                board[i][j++] = Integer.parseInt(String.valueOf(c));
            }
        }

        solution(0, 0);

        System.out.println(board[N - 1][M - 1]);
    }

    public static void solution(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] x_y = q.poll();

            for (int i = 0; i < MOVE_CNT; i++) {
                int nX = x_y[0] + X[i];
                int nY = x_y[1] + Y[i];

                if (nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if (board[nX][nY] == 0) continue;
                if (board[nX][nY] != 1) continue;

                board[nX][nY] = board[x_y[0]][x_y[1]] + 1;
                q.offer(new int[]{nX, nY});
            }

        }
    }
}