import java.util.*;

public class Main {

    final int MAX = 100 * 1000;

    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = MAX;
        t1 += 10;
        t2 += 10;
        temperature += 10;
        int[][] dy = new int[onboard.length][51];

        for (int i = 0; i < onboard.length; i++) {
            Arrays.fill(dy[i], MAX);
        }

        dy[0][temperature] = 0;

        // i = 분, sec = 현재온도.
        int endSec = 50;
        for (int i = 0; i < onboard.length - 1; i++) {
            for (int sec = 0; sec <= endSec; sec++) {
                if(onboard[i] == 1 && (sec < t1 || t2 < sec)) continue;
                // 에어컨 ON
                // STAY
                dy[i + 1][sec] = Math.min(dy[i + 1][sec], dy[i][sec] + b);
                // UP
                if (sec < endSec) dy[i + 1][sec + 1] = Math.min(dy[i + 1][sec + 1], dy[i][sec] + a);
                // DOWN
                if (sec >= 1) dy[i + 1][sec - 1] = Math.min(dy[i + 1][sec - 1], dy[i][sec] + a);

                // 에어컨 OFF
                if(temperature == sec) {
                  dy[i + 1][sec] = Math.min(dy[i + 1][sec], dy[i][sec]);
                } else if (temperature > sec && sec < endSec) {
                    // UP
                    dy[i + 1][sec + 1] = Math.min(dy[i + 1][sec + 1], dy[i][sec]);
                } else if (temperature < sec) {
                    // DOWN
                    dy[i + 1][sec - 1] = Math.min(dy[i + 1][sec - 1], dy[i][sec]);
                }
            }
        }

        for (int i = 0; i <= 50; i++) {
            if(onboard[onboard.length - 1] == 1 && (i < t1 || i > t2)) continue;
            answer = Math.min(answer, dy[onboard.length - 1][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int temperature = 28;
        int t1 = 18, t2 = 26;
        int a = 10, b = 8;
        int[] onboard = {0, 0, 1, 1, 1, 1, 1};
        // 40
        System.out.println(T.solution(temperature, t1, t2, a, b, onboard));
    }
}
