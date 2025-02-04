import java.util.*;

public class Main {
    /**
     * Contains Duplicate
     */

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Main().containsDuplicate(new int[]{1,2,3,4,1}));
    }
}