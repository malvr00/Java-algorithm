import java.util.*;

public class Main {

    /**
     * Merge Intervals
     */

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        List<int []> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] cur = intervals[0];
        list.add(cur);
        for(int i = 1; i < intervals.length; i++) {
            int[] nur = intervals[i];
            if(nur[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], nur[1]);
            } else {
                cur = nur;
                list.add(cur);
            }
        }

        int[][] answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Main().merge(new int[][]{{1, 4}, {4, 5}})));
    }
}