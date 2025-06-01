import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static boolean[][] ch;
    private static int answer;
    private static final int MOVE_CNT = 4;
    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            int j = 0;
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                board[i][j++] = Integer.parseInt(String.valueOf(c));
            }
        }

        solution(N, board);
    }

    public static void solution(final int N, int[][] board) {
        ch = new boolean[N][N];

        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                answer = 0;
                DFS(x, y, N, board);
                if (answer > 0) {
                    cnt++;
                    list.add(answer);
                }
            }
        }

        Collections.sort(list);

        System.out.println(cnt);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    public static void DFS(final int x, final int y, final int N, int[][] board) {
        if(ch[x][y] || board[x][y] == 0) return;

        answer++;
        ch[x][y] = true;

        for (int i = 0; i < MOVE_CNT; i++) {
            int nX = x + X[i];
            int nY = y + Y[i];

            if(nX < 0 || nY < 0 || nX >= N || nY >= N) continue;

            DFS(nX, nY, N, board);
        }
    }
}