import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    /*
        12. 토마토
     */

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Integer> Q = new LinkedList<>();
    public static int solution(int n, int m, int[][] frame) {
        int answer = -1;

        if (Q.isEmpty()) {
            answer = 0;
        }

        while (!Q.isEmpty()) {
            int qSize = Q.size();

            answer++;
            for (int i = 0; i < qSize / 2; i++) {
                int nowX = Q.poll();
                int nowY = Q.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = nowX + dx[j];
                    int nextY = nowY + dy[j];

                    if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && frame[nextX][nextY] == 0) {
                        frame[nextX][nextY] = 1;
                        Q.add(nextX);
                        Q.add(nextY);
                    }
                }
            }
        }

        boolean flag = true;
        for (int i = 1; i <= m; i++) {
            if(!flag) break;
            for (int j = 1; j <= n; j++) {
                if (frame[i][j] == 0) {
                    answer = -1;
                    flag = false;
                }
            }
        }

        return answer;
    }

    static int[][] dis;
    static Queue<Point> Q2 = new LinkedList<>();
    public static void BFS(int n, int m, int[][] frame){
        while (!Q2.isEmpty()) {
            Point tmp = Q2.poll();

            for (int j = 0; j < 4; j++) {
                int nextX = tmp.x + dx[j];
                int nextY = tmp.y + dy[j];

                if (nextX >= 1 && nextX <= m && nextY >= 1 && nextY <= n && frame[nextX][nextY] == 0) {
                    frame[nextX][nextY] = 1;
                    Q2.add(new Point(nextX, nextY));
                    dis[nextX][nextY] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] frame = new int[m + 1][n + 1];
        dis = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                frame[i][j] = kb.nextInt();
                if(frame[i][j] == 1) {
                    Q2.add(new Point(i, j));
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

        System.out.println(solution(n, m, frame));

        // 방법 2
        BFS(n, m, frame);
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(frame[i][j] == 0) flag = false;
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }
    }
}

