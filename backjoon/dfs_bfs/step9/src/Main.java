import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static boolean[][] ch;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
            }
        }

        System.out.println(solution(N, M, board));
    }

    public static int solution(final int N, final int M, int[][] board) {
        int[][] newBoard = copyArr(N, M, board);

        int year = 0;
        while(true){
            int area = 0;
            ch = new boolean[N][M];
            for (int x = 1; x < N - 1; x++) {
                for (int y = 1; y < M - 1; y++) {
                    if(ch[x][y]) continue;
                    if(newBoard[x][y] == 0) continue;

                    area++;
                    ch[x][y] = true;
                    DFS(x, y, newBoard);
                }
            }

            if(area >= 2) return year;

            // 더 이상 얼음이 없으면 중지
            if(area == 0) return 0;

            melt(N, M, newBoard, board);
            board = copyArr(N, M, newBoard);
            year++;
        }
    }

    public static int[][] copyArr(final int N, final int M, int[][] board) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) temp[i] = board[i].clone();
        return temp;
    }

    public static void melt(final int N, final int M, int[][] board, int[][] baseBoard) {
        for (int x = 1; x < N - 1; x++) {
            for (int y = 1; y < M - 1; y++) {
                int cnt = 0;
                for (int z = 0; z < 4; z++) {
                    int nX = X[z] + x;
                    int nY = Y[z] + y;

                    if(baseBoard[nX][nY] > 0) continue;

                    cnt++;
                }
                if(board[x][y] != 0) {
                    if(board[x][y] - cnt < 0) board[x][y] = 0;
                    else board[x][y] -= cnt;
                }
            }
        }
    }

    public static void DFS(int x, int y, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nX = X[i] + x;
            int nY = Y[i] + y;

            if(board[nX][nY] == 0 || ch[nX][nY]) continue;

            ch[nX][nY] = true;
            DFS(nX, nY, board);
        }
    }
}