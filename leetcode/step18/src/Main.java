import java.util.*;

public class Main {

    /**
     * 3Sum
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int lt = i + 1, rt = nums.length - 1;

            while(lt < rt) {
                int baseCnt = nums[i];
                int ltCnt = nums[lt];
                int rtCnt = nums[rt];
                int total = baseCnt + ltCnt + rtCnt;

                if(total == 0) {
                    answer.add(Arrays.asList(baseCnt, ltCnt, rtCnt));

                    while(lt < rt && ltCnt == nums[lt]) lt++;
                    while(lt < rt && rtCnt == nums[rt]) rt--;
                } else if(total > 0) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().threeSum(new int[]{-4,-1,1}));
    }
}