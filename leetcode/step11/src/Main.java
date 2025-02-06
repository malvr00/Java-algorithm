import java.util.*;

public class Main {
    /**
     * Find All Numbers Disappeared in an Array
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int i = 1; i <= n; i++) {
            if(!set.contains(i)) {
                answer.add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().findDisappearedNumbers(new int[]{1,2,4}));
    }
}