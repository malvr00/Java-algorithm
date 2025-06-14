import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int MAX = 0;

    private static boolean[][] ch;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
                MAX = Math.max(MAX, val);
            }
        }

        System.out.println(solution(N, board));
    }

    public static int solution(final int N, int[][] board) {
        int answer = 0;

        for (int i = 0; i < MAX; i++) {
            int area = 0;
            ch = new boolean[N][N];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if(board[x][y] <= i) continue;
                    if(ch[x][y]) continue;
                    // 최초 영역 시작지점 찾기
                    area++;
                    ch[x][y] = true;
                    DFS(x, y, N, i, board);
                }
            }
            answer = Math.max(answer, area);
        }

        return answer;
    }

    public static void DFS(final int x, final int y, final int N, final int point, int[][] board) {
        for (int i = 0; i < 4; i++) {
            int nX = x + X[i];
            int nY = y + Y[i];

            if(nX < 0 || nY < 0 || nX >= N || nY >= N) continue;
            if(board[nX][nY] <= point || ch[nX][nY]) continue;

            ch[nX][nY] = true;
            DFS(nX, nY, N, point, board);
        }
    }
}