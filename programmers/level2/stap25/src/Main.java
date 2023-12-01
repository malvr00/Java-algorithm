import java.util.*;

public class Main {

    /**
     * Level2
     * 행렬 테두리 회전하기
     */
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];
        int cnt = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = cnt++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int sY = queries[i][0] - 1;
            int sX = queries[i][1] - 1;
            int eY = queries[i][2];
            int eX = queries[i][3];
            int tmp = arr[sY][sX];
            int nAnswer = tmp;

            int x = sX;
            for (int y = sY; y < eY; y++) {
                for (; x < eX; x++) {
                    int tmp2 = arr[y][x];
                    arr[y][x] = tmp;
                    tmp = tmp2;

                    nAnswer = Math.min(nAnswer, tmp);
                }
                x--;
            }
            x--;

            for (int y = eY - 1; y >= sY; y--) {
                for (; x >= sX; x--) {
                    int tmp2 = arr[y][x];
                    arr[y][x] = tmp;
                    tmp = tmp2;

                    nAnswer = Math.min(nAnswer, tmp);
                }
                x++;
            }
            answer[i] = nAnswer;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            rows	columns	    queries	                                    result
            6	    6	        [[2,2,5,4],[3,3,6,6],[5,1,6,3]]	            [8, 10, 25]
            3	    3	        [[1,1,2,2],[1,2,2,3],[2,1,3,2],[2,2,3,3]]	[1, 1, 5, 3]
            100	    97	        [[1,1,100,97]]	                            [1]
         */
        int rows = 100;
        int columns = 97;
        int[][] queries = {{1,1,100,97}};
        Main main = new Main();
        int[] solution = main.solution(rows, columns, queries);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}