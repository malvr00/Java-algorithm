import java.util.*;

public class Main {

    /**
     * Level2.
     * n^2 배열 자르기
     */
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int answerIdx = 0;

        for (long i = left; i <= right; i++) {
            long row = i / n;
            long column = i - n * row;
            long num = 0;
            if (row >= column) {
                num = row + 1;
            } else {
                num = column + 1;
            }

            answer[answerIdx] = (int) num;
            answerIdx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            n	left	right	result
            3	2	    5	    [3,2,2,3]
            4	7	    14	    [4,3,3,3,4,4,4,4]
         */
        int n = 3;
        int left = 2;
        int right = 5;
        Main main = new Main();
        int[] solution = main.solution(n, left, right);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}