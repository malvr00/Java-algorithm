import java.util.*;

public class Main {

    /**
     * 강의.
     * 음수가 있는 부분수열 ( 해싱, 시간파싱 )
     */
    public int solution(int[] nums, int m){
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        // m - sum = 0 일 경우 상정
        map.put(0, 1);

        for (int s : nums) {
            sum += s;
            if (map.get(sum - m) != null) {
                answer += map.get(sum - m);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public int solution(int[] nums, int m, int version){
        int answer = 0;
        HashMap<Integer, Integer> nH = new HashMap<>();
        int sum = 0;
        nH.put(0, 1);
        for(int x : nums){
            sum += x;
            if(nH.containsKey(sum-m)) answer += nH.get(sum-m);
            nH.put(sum, nH.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}