import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Queue<int[]> Q = new LinkedList<>();
    private final static int[] Z = {-1, 1, 0, 0, 0, 0};
    private final static int[] X = {0, 0, 0, 0, -1, 1};
    private final static int[] Y = {0, 0, -1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        final int H = Integer.parseInt(st.nextToken());

        int[][][] board = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    int val = Integer.parseInt(st.nextToken());
                    board[i][x][y] = val;
                    if(val == 1) Q.offer(new int[]{i, x, y});
                }
            }
        }

        System.out.println(solution(M, N, H, board));
    }

    public static int solution(final int M, final int N, final int H, int[][][] board) {
        if(Q.isEmpty()) return -1;
        int answer = 0;

        while (!Q.isEmpty()) {
            int[] poll = Q.poll();
            for (int s = 0; s < 6; s++) {
                int nZ = poll[0] + Z[s];
                int nX = poll[1] + X[s];
                int nY = poll[2] + Y[s];

                if(nZ < 0 || nX < 0 || nY < 0 || nZ >= H || nX >= N || nY >= M) continue;
                if(board[nZ][nX][nY] == -1 || board[nZ][nX][nY] >= 1) continue;

                board[nZ][nX][nY] = board[poll[0]][poll[1]][poll[2]] + 1;
                Q.offer(new int[]{nZ, nX, nY});
            }
        }

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if(board[z][x][y] == 0) return -1;
                    else answer = Math.max(answer, board[z][x][y] - 1);
                }
            }
        }

        return answer;
    }
}