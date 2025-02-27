public class Main {

    /**
     * Level3.
     * [카카오] 파괴되지 않은 건물
     * imos
     */

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        int[][] dy = new int[board.length + 1][board[0].length + 1];

        for (int[] skillSet : skill) {
            int type = skillSet[0];
            int r1 = skillSet[1];
            int c1 = skillSet[2];
            int r2 = skillSet[3];
            int c2 = skillSet[4];
            int degree = skillSet[5];

            if(type == 1) degree *= -1;

            // imos
            // 2 차원 `imos`는 `세로 합` 후 `가로 합` 총 2 번 시행
            dy[r1][c1] += degree;
            dy[r1][c2 + 1] += degree * -1;
            dy[r2 + 1][c1] += degree * -1;
            dy[r2 + 1][c2 + 1] += degree;
        }

        // 세로 합
        for (int i = 0; i < dy[0].length; i++) {
            for (int j = 0; j < dy.length - 1; j++) {
                dy[j + 1][i] += dy[j][i];
            }
        }
        // 가로 합
        for (int i = 0; i < dy.length; i++) {
            for (int j = 0; j < dy[i].length - 1; j++) {
                dy[i][j + 1] += dy[i][j];
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] + dy[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill = {{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};

        System.out.println(T.solution(board, skill));
    }
}