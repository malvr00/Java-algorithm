public class Main {

    /**
     * Level3.
     * 등굣길
     * DP
     */

    public int solution(int m, int n, int[][] puddles) {
        final int VAL = 1_000_000_007;

        int[][] board = new int[m + 1][n + 1];
        boolean[][] ch = new boolean[m + 1][n + 1];

        for (int i = 0; i < puddles.length; i++) {
            ch[puddles[i][0]][puddles[i][1]] = true;
        }

        board[1][1] = 1;
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if(x == 1 && y == 1) continue;

                if (ch[x][y]) {
                    board[x][y] = 0;
                } else {
                    int right = board[x][y - 1];
                    int up = board[x - 1][y];

                    board[x][y] += (right + up) % VAL;
                }
            }
        }

        return board[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(4, 3, new int[][]{{2, 2}}));
    }
}