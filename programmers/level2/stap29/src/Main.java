public class Main {

    /**
     * Level2.
     * 삼각 달팽이
     */
    public int[] solution(int n) {
        int len = 0;
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            len += i;
        }

        int[] answer = new int[len];
        int[][] val = new int[n][n];

        int y = -1;
        int x = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    y++;
                } else if (i % 3 == 1) {
                    x++;
                } else if (i % 3 == 2) {
                    y--;
                    x--;
                }

                val[y][x] = ++cnt;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (val[i][j] != 0) {
                    answer[idx++] = val[i][j];
                } else {
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            n	result
            4	[1,2,9,3,10,8,4,5,6,7]
            5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
            6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
         */
        int n = 5;
        Main main = new Main();
        int[] solution = main.solution(n);

        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}