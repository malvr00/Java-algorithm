import java.util.*;

public class Main {

    /**
     * Level2.
     * 타겟 넘버
     */
    static int answer = 0;
    public void dfs(int lv, int[] numbers, int target, int sum, int i) {
        if (lv == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            for (; i < numbers.length; i++) {
                dfs(lv + 1, numbers, target, sum + numbers[i], i + 1);
                dfs(lv + 1, numbers, target, sum - numbers[i], i + 1);
            }
        }
    }
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Main main = new Main();
        int solution = main.solution(numbers, target);
        System.out.println(solution);
    }
}