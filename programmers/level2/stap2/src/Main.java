import java.util.*;

public class Main {

    /**
     * Level2.
     * 문제: 연속된 부분 수열의 합 ( Slide Window )
     */
    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;
        int sum = 0;
        int lt = 0;

        for (int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum >= k) {
                if (sum == k) {
                    int nowLan = answer[1] - answer[0];
                    int nextLan = i - lt;
                    if (nextLan < nowLan) {
                        answer[0] = lt;
                        answer[1] = i;
                    }
                }
                sum -= sequence[lt++];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
               sequence                 k       result
            [1, 2, 3, 4, 5]	            7	    [2, 3]
            [1, 1, 1, 2, 3, 4, 5]	    5	    [6, 6]
            [2, 2, 2, 2, 2]	            6	    [0, 2]
         */
        int[] arr = {1, 2, 3, 4, 5};
        int k = 7;
        solution(arr, k);
    }
}