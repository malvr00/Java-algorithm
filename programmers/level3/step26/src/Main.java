import java.util.*;

public class Main {

    /**
     * Level3.
     * 입국심사
     * 이분 탐색
     */

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left = 1L;
        long right = (long) times[times.length - 1] * n; // 최대 상담시간

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int n = 6;
        int[] times = {7, 10};

        System.out.println(m.solution(n, times));
    }
}