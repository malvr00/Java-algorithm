import java.util.*;

public class Main {

    /**
     * 강의.
     * 최대길이 바이토닉 수열 ( 시뮬레이션 & 구현 )
     */

    public int solution(int[] nums){
        /*
            내 풀이
         */
        int answer = 0;
        boolean flag = false;
        int idx = 0;
        int cnt = 1;

        while (idx < nums.length - 1) {
            if (nums[idx] == nums[idx + 1]) {
                idx++;
                if (cnt >= 3) {
                    answer = Math.max(answer, cnt);
                }
                cnt = 0;
            } else {
                if (nums[idx] < nums[idx + 1]) {
                    if (flag) {
                        answer = Math.max(answer, cnt);
                        flag = false;
                        cnt = 1;
                    }
                } else {
                    flag = true;
                }
                idx++;
            }
            cnt++;
        }

        if (cnt >= 3) {
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public int solution(int[] nums, int version){
        /*
            강의
         */
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        // 봉우리 지점 index peaks 에 저장
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }
        for(int x : peaks){
            int left = x;
            int right = x;
            int cnt = 1;
            // 봉우리 기준 왼쪽으로 이동
            while(left-1 >= 0 && nums[left-1] < nums[left]){
                left--;
                cnt++;
            }
            // 봉우리 기준 오른쪽으로 이동
            while(right+1 < n && nums[right] > nums[right+1]){
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}