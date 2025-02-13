import java.util.*;

public class Main {

    /**
     * Level 3
     * 인사고과
     * Greedy
     */
    public int solution(int[][] scores) {
        // [0] = 근무, [1] = 직원
        int answer = 1;
        int[] my = scores[0];

        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int max = 0;
        for (int[] score : scores) {
            // 직원 비교
            if (max > score[1]) {
                if (Arrays.equals(my, score)) {
                    return -1;
                }
            } else {
                if(my[0] + my[1] < score[0] + score[1]) answer++;
            }

            max = Math.max(max, score[1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        System.out.println(T.solution(scores));
    }
}