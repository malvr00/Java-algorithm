import java.util.*;

public class Main {

    /**
     * 강의.
     * 최대 길이 연속수열 ( 자료구조 활용 )
     */
    public int solution(int[] nums){
        if(nums.length == 0) return 0;

        int answer = 0;
        Arrays.sort(nums);

        int cnt = 1;
        int sVal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((sVal + 1) == nums[i]) {
                cnt++;
            } else if ((sVal + 1) < nums[i]) {
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
            sVal = nums[i];
        }

        answer = Math.max(answer, cnt);

        return answer;
    }

    public int solution(int[] nums, int version){
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int x : set){
            if(set.contains(x - 1)) continue;
            int cnt = 0;
            while(set.contains(x)){
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}, 2));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}