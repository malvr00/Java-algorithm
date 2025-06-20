import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static int answer = 0;

    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(startX, startY, startD, board);

        System.out.print(answer);
    }

    public static void solution(int startX, int startY, int startD, int[][] board) {
        DFS(startX, startY, startD, board);
    }

    public static void DFS(int x, int y, int d, int[][] board) {
        // 1 번
        if(board[x][y] == 0) {
            board[x][y] = 2;
            answer++;
        }

        // 3 번
        for(int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nX = x + X[d];
            int nY = y + Y[d];

            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;

            if(board[nX][nY] == 0) {
                DFS(nX, nY, d, board);
                return;
            }
        }

        // 2 번
        int back = (d + 2) % 4;
        int nX = x + X[back];
        int nY = y + Y[back];

        if(nX < 0 || nX >= N || nY < 0 || nY >= M || board[nX][nY] == 1) return;

        DFS(nX, nY, d, board);
    }
}