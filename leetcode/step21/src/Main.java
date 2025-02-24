import java.util.Arrays;

public class Main {

    /**
     * Rotate Image
     */

    private void copyArr(int[][] copy, int[][] board) {
        for(int i = 0; i < board.length; i++) {
            copy[i] = board[i].clone();
        }
    }
    public int[][] rotate(int[][] matrix) {
        int[][] board = new int[matrix.length][matrix.length];
        copyArr(board, matrix);

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length - i - 1] = board[i][j];
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Main().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}