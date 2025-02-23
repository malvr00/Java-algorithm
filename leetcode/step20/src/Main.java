import java.util.*;

public class Main {

    /**
     * Set Matrix Zeroes
     */

    public int[][] setZeroes(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;

        List<int []> list = new ArrayList<>();

        for(int x = 0; x < M; x++) {
            for(int y = 0; y < N; y++) {
                if(matrix[x][y] == 0) list.add(new int[]{x, y});
            }
        }

        for(int[] cur : list) {
            int x = cur[0];
            int y = cur[1];

            // up
            for(int nX = x; nX >= 0; nX--) {
                matrix[nX][y] = 0;
            }
            // down
            for(int nX = x; nX < M; nX++) {
                matrix[nX][y] = 0;
            }
            // left
            for(int nY = y; nY >= 0; nY--) {
                matrix[x][nY] = 0;
            }
            // right
            for(int nY = y; nY < N; nY++) {
                matrix[x][nY] = 0;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Main().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})));
    }
}