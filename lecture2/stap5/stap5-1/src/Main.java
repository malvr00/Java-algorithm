import java.util.*;

public class Main {
    public int solution(int[] nums, int m){
        if(nums.length == 0) return 0;
        int answer = 0;
        Arrays.sort(nums);

        int lt = 0;
        int rt = nums.length - 1;
        while (lt <= rt) {
            int sum = nums[lt] + nums[rt];
            if (sum <= m) {
                lt++;
            }
            answer++;
            rt--;
        }

        return answer;
    }

    public int solution(int[] nums, int m, int version){
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(nums[left] + nums[right] <= m){
                answer++;
                left++;
                right--;
            }
            else{
                answer++;
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}