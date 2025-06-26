import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};
    private static final Queue<int[]> Q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
                if(val == 1) Q.offer(new int[]{i, j});
            }
        }

        System.out.println(solution(board));
        br.close();
    }

    public static int solution(int[][] board) {
        while(!Q.isEmpty()) {
            int[] cur = Q.poll();
            for(int i = 0; i < 4; i++) {
                int nX = cur[0] + X[i];
                int nY = cur[1] + Y[i];

                if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
                if(board[nX][nY] == -1 || board[nX][nY] >= 1) continue;

                board[nX][nY] = board[cur[0]][cur[1]] + 1;
                Q.offer(new int[]{nX, nY});
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 0) return -1;
                else answer = Math.max(answer, board[i][j] - 1);
            }
        }
        return answer;
    }
}