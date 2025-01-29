import java.util.*;

public class Main {

    /**
     * Kth Largest Element in an Array
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        return nums[n - k];
    }

    public static void main(String[] args) {
        System.out.println(new Main().findKthLargest(new int[]{1,2,3,4,5,6}, 2));
    }
}