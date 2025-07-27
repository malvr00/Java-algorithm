import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        boolean[][] ch = new boolean[N][N];

        int areaNumber = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(board[x][y] == 0 || ch[x][y]) continue;
                ch[x][y] = true;
                board[x][y] = areaNumber;
                setArea(board, ch, x, y, areaNumber++);
            }
        }

        int[][] visited = new int[N][N];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++) Arrays.fill(visited[i], -1);

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(board[x][y] == 0) continue;
                for (int i = 0; i < 4; i++) {
                    int nX = x + X[i];
                    int nY = y + Y[i];
                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;

                    if(board[nX][nY] == 0) {
                        q.offer(new int[]{x, y});
                        visited[x][y] = 0;
                        break;
                    }
                }
            }

        }

        return bridge(q, visited, board);
    }

    public static void setArea(int[][] board, boolean[][] ch, int startX, int startY, int areaNumber) {
        for(int i = 0; i < 4; i++) {
            int nX = startX + X[i];
            int nY = startY + Y[i];

            if(nX < 0 || nX >= N || nY < 0 || nY >= N || ch[nX][nY]) continue;
            if(board[nX][nY] == 0) continue;

            ch[nX][nY] = true;
            board[nX][nY] = areaNumber;
            setArea(board, ch, nX, nY, areaNumber);
        }
    }

    public static int bridge(final Queue<int[]> Q, int[][] visited, int[][] board) {
        int answer = Integer.MAX_VALUE;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + X[i];
                int nY = cur[1] + Y[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) continue;

                if(board[nX][nY] == 0) {
                    visited[nX][nY] = visited[cur[0]][cur[1]] + 1;
                    board[nX][nY] = board[cur[0]][cur[1]];
                    Q.offer(new int[]{nX, nY});
                }

                if (board[nX][nY] != board[cur[0]][cur[1]]) {
                    answer = Math.min(answer, visited[nX][nY] + visited[cur[0]][cur[1]]);
                }
            }
        }

        return answer;
    }
}