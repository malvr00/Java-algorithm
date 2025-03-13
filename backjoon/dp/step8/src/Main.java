import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] dy;
    private static int N;
    private static int M;
    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 0 || M == 0) {
            System.out.println(0);
            return;
        }

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dy = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dy[i], -1);
        }

        int answer = solution(0, 0, board);
        System.out.println(answer);
    }

    public static int solution(int nowX, final int nowY, int[][] board) {
        if(N - 1 == nowX && M - 1 == nowY) return 1;
        if(dy[nowX][nowY] != -1) return dy[nowX][nowY];

        // 방문한 곳 0 반환 ( 중복 방문 방지 )
        dy[nowX][nowY] = 0;

        for (int i = 0; i < 4; i++) {
            int nX = X[i] + nowX;
            int nY = Y[i] + nowY;

            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;
            if(board[nowX][nowY] <= board[nX][nY]) continue;

            dy[nowX][nowY] += solution(nX, nY, board);
        }

        return dy[nowY][nowX];
    }
}