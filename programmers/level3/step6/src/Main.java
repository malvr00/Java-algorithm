import java.util.*;

public class Main {

    /**
     * Level 3
     * 연속 펄스 부분 수열의 합
     * 단순 구현 ( DP 를 곁들인 )
     */
    public long solution(int[] sequence) {
        long answer = 0L;

        boolean flag = true;

        long sumA = 0L;
        long sumB = 0L;

        for (int val : sequence) {
            sumB += flag ? -val : val;
            sumA += flag ? val : -val;

            sumA = Math.max(0L, sumA);
            sumB = Math.max(0L, sumB);

            flag = !flag;
            answer = Math.max(answer, Math.max(sumA, sumB));
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        System.out.println(T.solution(sequence));
    }
}