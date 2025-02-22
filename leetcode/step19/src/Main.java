import java.util.*;

public class Main {

    /**
     * Minimum Size Subarray Sum
     */

    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        int sum = 0, lt = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while(sum >= target) {
                answer = Math.min(answer, i - lt + 1);
                sum -= nums[lt];
                lt++;
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().minSubArrayLen(6, new int[]{6}));
    }
}