import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static int N;
    private static int M;
    private static int[][] board;
    private static Node start;
    private static Node end;

    private static final int[] X = {0, 1, 0, -1};
    private static final int[] Y = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        start = new Node(x, y, modifyDist(dist));

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dist = Integer.parseInt(st.nextToken());
        end = new Node(x, y, modifyDist(dist));

        System.out.println(solution());

    }

    public static int modifyDist(int dist) {
        if(dist == 1) return 0;
        if(dist == 2) return 2;
        if(dist == 3) return 1;

        return 3;
    }

    public static int solution() {
        int[][][] visited = new int[N + 1][M + 1][5];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y][start.dist] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if(cur.x == end.x && cur.y == end.y && cur.dist == end.dist) return visited[cur.x][cur.y][cur.dist];

            int left = (cur.dist + 1) % 4;
            if(visited[cur.x][cur.y][left] == -1) {
                visited[cur.x][cur.y][left] = visited[cur.x][cur.y][cur.dist] + 1;
                q.offer(new Node(cur.x, cur.y, left));
            }

            int right = (cur.dist + 3) % 4;
            if(visited[cur.x][cur.y][right] == -1) {
                visited[cur.x][cur.y][right] = visited[cur.x][cur.y][cur.dist] + 1;
                q.offer(new Node(cur.x, cur.y, right));
            }

            for (int j = 1; j <= 3; j++) {
                int nX = cur.x + X[cur.dist] * j;
                int nY = cur.y + Y[cur.dist] * j;

                if(nX < 1 || nY < 1 || nX > N || nY > M) continue;
                if(board[nX][nY] == 1) break;
                if(visited[nX][nY][cur.dist] != -1) continue;

                visited[nX][nY][cur.dist] = visited[cur.x][cur.y][cur.dist] + 1;
                q.offer(new Node(nX, nY, cur.dist));

            }
        }

        return 0;
    }
}