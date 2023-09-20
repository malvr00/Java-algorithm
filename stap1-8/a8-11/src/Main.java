import java.util.*;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    /*
        11. 미로탐색(BFS)
     */

    static int[][] board = new int[8][8];
    static int[] bx = {-1, 0, 1, 0};
    static int[] by = {0, 1, 0, -1};
    public static int solution(int x, int y) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);

        while (!q.isEmpty()) {
            int qSize = q.size();
            answer++;
            for (int size = 0; size < qSize / 2; size++) {
                int nowX = q.poll();
                int nowY = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = nowX + bx[i];
                    int ny = nowY + by[i];

                    if (nx == 7 && ny == 7) {
                        return answer;
                    }

                    if (nx >= 1 && nx <= 7 && ny <= 7 && ny >=1 && board[nx][ny] == 0) {
                        board[nx][ny] = 1;
                        q.add(nx);
                        q.add(ny);
                    }
                }
            }
        }

        return -1;
    }

    static int[][] dis;
    public static void BFS(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));

        while (!Q.isEmpty()) {
            Point tmp = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + bx[i];
                int ny = tmp.y + by[i];
                if (nx >= 1 && nx <= 7 && ny <= 7 && ny >=1 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

//        int n = kb.nextInt();
//        int r = kb.nextInt();

        dis = new int[8][8];

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        board[1][1] = 1;

        BFS(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }


        System.out.println(solution(1, 1));

    }
}