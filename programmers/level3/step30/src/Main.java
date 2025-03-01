public class Main {

    /**
     * Level3.
     * 정수 삼각형
     * DP
     */

    public int solution(int[][] triangle) {
        int answer = 0;
        final int N = triangle.length;
        int[][] dy = new int[N][N];

        dy[0][0] = triangle[0][0];

        // i = 뎁스, j = 뎁스의 원소 그리드 누적합
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dy[i][j] = dy[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dy[i][j] = dy[i - 1][j - 1];
                } else {
                    // 왼쪽 대각선, 오른쪽 대각선
                    dy[i][j] = Math.max(dy[i - 1][j - 1] + triangle[i][j], dy[i - 1][j] + triangle[i][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dy[N - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[][]{{7,},{3, 8}, {8, 1 ,0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}