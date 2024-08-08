import java.util.*;

public class Main {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        Arrays.sort(nums);

        int[] ch = new int[nums[nums.length - 1] + 1];

        int idx = 0;
        for (int num : nums) {
            if (ch[num] == 0) {
                ch[num * 2] = 1;
                answer[idx++] = num;
            }
        }

        return answer;
    }

    public int[] solution(int[] nums, int version){
        int[] answer = new int[nums.length / 2];
        HashMap<Integer, Integer> nH = new HashMap<>();
        for(int x : nums) nH.put(x, nH.getOrDefault(x, 0) + 1);
        Arrays.sort(nums);
        int idx = 0;
        for(int x : nums){
            if(nH.get(x) == 0) continue;
            answer[idx] = x;
            idx++;
            nH.put(x, nH.get(x) - 1);
            nH.put(x*2, nH.get(x*2) - 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}