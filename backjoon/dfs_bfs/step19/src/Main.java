import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] M_X = {-1, 0, 1, 0};
    private static final int[] M_Y = {0, 1, 0, -1};

    private static final int N = 12;
    private static final int M = 6;

    private static final char R = 'R';
    private static final char G = 'G';
    private static final char B = 'B';
    private static final char P = 'P';
    private static final char Y = 'Y';
    private static final char NONE = '.';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            int j = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (char c : s.toCharArray()) {
                board[i][j++] = c;
            }
        }

        System.out.println(solution(board));
    }

    public static int solution(char[][] board) {
        int answer = 0;

        while(true) {
            List<int[]> roundPuyoList = new ArrayList<>();
            boolean[][] visited = new boolean[N][M];
            boolean key = false;

            for (int i = N - 1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] == NONE || visited[i][j]) continue;

                    List<int[]> puyoList = new ArrayList<>();
                    puyopuyo(board, puyoList, visited, i, j, board[i][j]);

                    if(puyoList.size() >= 4) {
                        key = true;
                        roundPuyoList.addAll(puyoList);
                    }
                }
            }

            if(!key) break;

            setBoardDefault(board, roundPuyoList);
            setBlockDown(board);
            answer++;
        }

        return answer;
    }

    public static void puyopuyo(char[][] board, List<int[]> puyoList, boolean[][] visited,
                                int startX, int startY, char block) {

        visited[startX][startY] = true;
        puyoList.add(new int[]{startX, startY});

        for (int i = 0; i < 4; i++) {
            int nX = startX + M_X[i];
            int nY = startY + M_Y[i];

            if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
            if(board[nX][nY] != block || visited[nX][nY]) continue;

            puyopuyo(board, puyoList, visited, nX, nY, block);
        }
    }

    public static void setBoardDefault(char[][] board, List<int[]> puyoList) {
        for (int[] puyo : puyoList) {
            board[puyo[0]][puyo[1]] = NONE;
        }
    }

    public static void setBlockDown(char[][] board) {
        for (int i = N - 2; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == NONE || board[i + 1][j] != NONE) continue;
                for (int z = i; z <= N - 2; z++) {
                    if(board[z][j] == NONE || board[z + 1][j] != NONE) continue;
                    board[z + 1][j] = board[z][j];
                    board[z][j] = NONE;
                }
            }
        }
    }
}