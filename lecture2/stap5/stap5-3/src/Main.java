import java.util.*;

public class Main {

    public int solution(int n, int[] nums){
        int answer = 0;

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int min = Math.max(i - nums[i], 0);
            int max = Math.min(i + nums[i], n);
            list.add(new int[]{min, max});
        }

        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int sT = 0;
        int eT = 0;

        for (int[] num : list) {
            if (num[0] <= sT) {
                eT = Math.max(num[1], eT);
            } else {
                if(sT == eT) return -1;
                answer++;
                if(eT == n) break;
                sT = eT;
            }
        }

        return answer;
    }

    public int solution(int n, int[] nums, int version){
        int answer = 0;
        int[][] line = new int[nums.length + 1][2];
        for(int i = 0; i <= n; i++){
            line[i][0] = Math.max(0, i - nums[i]);
            line[i][1] = Math.min(n, i + nums[i]);
        }
        Arrays.sort(line, (a, b) -> a[0] - b[0]);
        int start = 0, end = 0, i = 0;
        while(i < line.length){
            while(i < line.length && line[i][0] <= start){
                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;
            if(end == n) return answer;
            if(start == end) return -1;
            start = end;
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
        System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));
        System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}, -2));
        System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
    }
}