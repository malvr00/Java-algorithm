import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;

    private static int[] startPosition = new int[2];
    private static Queue<int[]> waterQ = new LinkedList<>();

    private static final char START = 'S';
    private static final char END = 'D';
    private static final char WATER = '*';
    private static final char WALL = 'X';
    private static final String IMPASSABLE = "KAKTUS";

    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            int j = 0;
            for (char c : line.toCharArray()) {
                if(c == START) startPosition = new int[]{i, j};
                else if(c == WATER) waterQ.add(new int[]{i, j});
                board[i][j++] = c;
            }
        }

        System.out.println(solution(board));

        br.close();
    }

    private static String solution(char[][] board) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();

        q.offer(startPosition);
        board[startPosition[0]][startPosition[1]] = WALL;

        while(!q.isEmpty()) {
            setWater(board);

            answer++;
            int size = q.size();
            for(int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nX = cur[0] + X[i];
                    int nY = cur[1] + Y[i];

                    if(nX < 0 || nY < 0 || nX >= R || nY >= C) continue;
                    if(board[nX][nY] == WALL || board[nX][nY] == WATER) continue;
                    if(board[nX][nY] == END) return String.valueOf(answer);

                    board[nX][nY] = WALL;
                    q.offer(new int[]{nX, nY});
                }
            }
        }

        return IMPASSABLE;
    }

    public static void setWater(char[][] board) {
        int size = waterQ.size();
        for (int s = 0; s < size; s++) {
            int[] cur = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + X[i];
                int nY = cur[1] + Y[i];

                if(nX < 0 || nY < 0 || nX >= R || nY >= C) continue;
                if(board[nX][nY] == WALL || board[nX][nY] == END || board[nX][nY] == WATER) continue;

                board[nX][nY] = WATER;
                waterQ.add(new int[]{nX, nY});
            }
        }
    }
}