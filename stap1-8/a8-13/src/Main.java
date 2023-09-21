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
        13. 섬나라 아일랜드 (DFS)
     */

    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    answer++;
                    myDFS(i, j, n);
                }
            }
        }

        return answer;
    }

    public static void myDFS(int x, int y, int n) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                myDFS(nx, ny, n);
            }
        }
    }

    static int answer = 0;
    public static void solution2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, n);
                }
            }
        }
    }

    public static void DFS(int x, int y, int n){
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx, ny, n);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        board = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        System.out.println(solution(n));

    }
}

