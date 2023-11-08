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
        14. 섬나라 아일랜드 (BFS)
     */

    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Integer> Q = new LinkedList<>();
    public static int solution(int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    Q.add(i);
                    Q.add(j);
                    answer++;
                    myBFS(n);
                }
            }
        }

        return answer;
    }

    public static void myBFS(int n) {
        while (!Q.isEmpty()) {
            int qSize = Q.size();
            int x = Q.poll();
            int y = Q.poll();
            for (int j = 0; j < qSize / 2; j++) {
                for (int i = 0; i < dx.length; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                        board[nx][ny] = 0;
                        Q.add(nx);
                        Q.add(ny);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n));

    }
}

