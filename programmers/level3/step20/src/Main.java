import java.util.*;

public class Main {

    /**
     * Level3. 광고 삽입 (Kakao)
     * imos + 윈도우 슬라이드
     */

    int toSec(String time) {
        String[] p = time.split(":");
        return Integer.parseInt(p[0]) * 3600
                + Integer.parseInt(p[1]) * 60
                + Integer.parseInt(p[2]);
    }

    String toTime(int sec) {
        int h = sec / 3600;    sec %= 3600;
        int m = sec / 60;      sec %= 60;
        int s = sec;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int P = toSec(play_time);
        int L = toSec(adv_time);
        long[] diff = new long[P + 2];

        // 1) 로그 차분 반영
        for (String log : logs) {
            String[] t = log.split("-");
            int s = toSec(t[0]);
            int e = toSec(t[1]);
            diff[s] += 1;
            diff[e] -= 1;
        }

        // 2) 초별 시청자 수 누적
        long[] viewers = new long[P + 1];
        viewers[0] = diff[0];
        for (int i = 1; i <= P; i++) {
            viewers[i] = viewers[i-1] + diff[i];
        }

        // 3) 시청자 수 누적합 → 구간 총 재생시간
        long[] acc = new long[P + 1];
        acc[0] = viewers[0];
        for (int i = 1; i <= P; i++) {
            acc[i] = acc[i-1] + viewers[i];
        }

        // 4) 슬라이딩 윈도우로 최댓값 구하기
        long maxTime = acc[L-1];  // 구간 [0, L-1]
        int bestStart = 0;
        for (int start = 1; start + L - 1 <= P; start++) {
            long end = start + L - 1;
            long total = acc[(int)end] - acc[start - 1];
            if (total > maxTime) {
                maxTime = total;
                bestStart = start;
            }
        }

        return toTime(bestStart);
    }

    public static void main(String[] args) {
        Main m = new Main();
        String play_time = "02:03:55", adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(m.solution(play_time, adv_time, logs));
    }
}