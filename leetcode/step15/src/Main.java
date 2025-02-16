import java.util.Arrays;

public class Main {

    /**
     * Two Sum II - Input Array Is Sorted
     */

    public int[] twoSum(int[] numbers, int target) {
        int lt = 0, rt = numbers.length - 1;
        while(lt < rt) {
            if(numbers[lt] + numbers[rt] > target) {
                rt--;
            } else if(numbers[lt] + numbers[rt] < target) {
                lt++;
            } else {
                return new int[]{lt + 1, rt + 1};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main().twoSum(new int[]{1, 2, 3}, 5)));
    }
}