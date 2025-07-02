import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final String FINISH = "123456780";

    private static final int N = 3;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    private static class State {
        int x, y, step;
        int[][] board;

        public State(int x, int y, int step, int[][] board) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.board = board;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[N][N];
        int sX = 0, sY = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;
                if(val == 0) {
                    sX = i;
                    sY = j;
                }
            }
        }

        System.out.println(solution(sX, sY, board));
    }

    public static int solution(int startX, int startY, int[][] board) {
        String startKey = encode(board);
        if(FINISH.equals(startKey)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<State> Q = new LinkedList<>();

        visited.add(startKey);
        Q.offer(new State(startX, startY, 0, copyArr(board)));

        while(!Q.isEmpty()) {
            State now = Q.poll();

            if(FINISH.equals(encode(now.board))) return now.step;

            for(int i = 0; i < 4; i++) {
                int nX = now.x + X[i];
                int nY = now.y + Y[i];

                if(nX < 0 || nY < 0 || nX >= N || nY >= N) continue;

                int[][] newBoard = copyArr(now.board);

                newBoard[now.x][now.y] = newBoard[nX][nY];
                newBoard[nX][nY] = 0;

                if(visited.contains(encode(newBoard))) continue;

                visited.add(encode(newBoard));
                Q.offer(new State(nX, nY, now.step + 1, newBoard));
            }
        }

        return -1;
    }

    public static String encode(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    public static int[][] copyArr(int[][] board) {
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++) temp[i] = board[i].clone();
        return temp;
    }
}