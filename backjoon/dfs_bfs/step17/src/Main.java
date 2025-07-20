import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int K;

    private static final int[] X = {-1, 0, 1, 0};
    private static final int[] Y = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][] blocks = new int[K][4];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            blocks[i][0] = Integer.parseInt(st.nextToken());
            blocks[i][1] = Integer.parseInt(st.nextToken());
            blocks[i][2] = Integer.parseInt(st.nextToken());
            blocks[i][3] = Integer.parseInt(st.nextToken());
        }

        int[] answer = solution(board, blocks);
        System.out.println(answer.length);
        int i = 0;
        for (int value : answer) {
            String s = i++ != answer.length - 1 ? value + " " : String.valueOf(value);
            System.out.print(s);
        }
    }

    public static int[] solution(int[][] board, int[][] blocks) {
        List<Integer> answer = new ArrayList<>();

        for (int[] block : blocks) {
            setBlock(board, block[1], block[0], block[3] - 1, block[2] - 1);
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if(board[x][y] == 1) continue;
                int cnt = 1;
                board[x][y] = 1;
                cnt = BFS(board, x, y, cnt);

                answer.add(cnt);
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void setBlock(int[][] board, int startX, int startY, int endX, int endY) {
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                board[x][y] = 1;
            }
        }
    }

    public static int BFS(int[][] board, int startX, int startY, int cnt) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nX = cur[0] + X[i];
                int nY = cur[1] + Y[i];

                if(nX < 0 || nX >= N || nY < 0 || nY >= M || board[nX][nY] == 1) continue;

                cnt++;
                board[nX][nY] = 1;
                queue.offer(new int[]{nX, nY});
            }
        }

        return cnt;
    }
}