import java.util.Arrays;

public class Main {

    /**
     * TwoSum
     */

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(Arrays.toString(m.twoSum(new int[]{3, 3}, 6)));
    }
}