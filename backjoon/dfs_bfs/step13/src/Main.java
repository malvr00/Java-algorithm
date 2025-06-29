import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] visited;

    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};
    private static final int[] JX = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static final int[] JY = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        visited = new int[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(K, N, M, board));
    }

    public static int solution(final int K, final int N, final int M, int[][] board) {
        Queue<int[]> Q = new LinkedList<>();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++) Arrays.fill(visited[i][j], -1);
        visited[0][0][0] = 0;

        Q.offer(new int[]{0, 0, 0});

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();

            if(cur[0] == N - 1 && cur[1] == M - 1) return visited[cur[0]][cur[1]][cur[2]];

            if(cur[2] < K){
                for (int i = 0; i < 8; i++) {
                    int nX = cur[0] + JX[i];
                    int nY = cur[1] + JY[i];
                    int used = cur[2] + 1;

                    if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                    if(board[nX][nY] == 1 || visited[nX][nY][used] != -1) continue;

                    visited[nX][nY][used] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    Q.offer(new int[]{nX, nY, used});
                }
            }

            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + X[i];
                int nY = cur[1] + Y[i];
                int used = cur[2];

                if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if(board[nX][nY] == 1 || visited[nX][nY][used] != -1) continue;

                visited[nX][nY][used] = visited[cur[0]][cur[1]][used] + 1;
                Q.offer(new int[]{nX, nY, used});
            }
        }

        return -1;
    }
}