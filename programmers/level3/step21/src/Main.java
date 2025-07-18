import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    /**
     * Level3.
     * 경주로 건설 (KAKAO)
     * BFS + 다익스트라
     */

    static public class Node {
        int x;
        int y;
        int d;
        int cost;

        public Node(int x, int y, int d, int cost) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        final int[] X = {-1, 1, 0, 0};
        final int[] Y = {0, 0, -1, 1};
        int len = board.length;

        final int endX = len - 1, endY = len - 1;

        int[][][] ch = new int[len][len][4];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(cur -> cur.cost));

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                Arrays.fill(ch[i][j], Integer.MAX_VALUE);
            }
        }

        // 4 방향 체크 배열 값 초기화
        for (int i = 0; i < 4; i++) {
            ch[0][0][i] = 0;
            q.offer(new Node(0, 0, i, 0));
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 해당 경로에 이미 최소 값의 경로가 존재하면 종료
            if(cur.cost > ch[cur.x][cur.y][cur.d]) continue;

            for (int j = 0; j < 4; j++) {
                int nX = cur.x + X[j];
                int nY = cur.y + Y[j];

                if(nX < 0 || nX >= len || nY < 0 || nY >= len) continue;
                if(board[nX][nY] == 1) continue;

                // 이전 경로와 현재가 같은 경로면 '+ 100' 다른 경로라면 '+ 600'
                int newCost = cur.cost + 100 + (cur.d == j ? 0 : 500);

                // 다음 도착할 경로에 이미 최소 값의 경로가 존재하지 않는다면 저장
                if (newCost < ch[nX][nY][j]) {
                    ch[nX][nY][j] = newCost;
                    q.offer(new Node(nX, nY, j, newCost));
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, ch[endX][endY][d]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(m.solution(board));
    }
}