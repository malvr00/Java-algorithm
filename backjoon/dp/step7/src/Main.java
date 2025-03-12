import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 골드 5
     * 퇴사 2
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] values = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            values[i][0] = Integer.parseInt(st.nextToken());
            values[i][1] = Integer.parseInt(st.nextToken());
        }

        solution(N, values);
    }

    public static void solution(int N, int[][] schedules) {
        int[] dy = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            // 이전 날짜 누적
            dy[i] = Math.max(dy[i], dy[i - 1]);

            int t = schedules[i - 1][0];
            int p = schedules[i - 1][1];

            if (i + t <= N + 1) {
                dy[i + t] = Math.max(dy[i + t], dy[i] + p);
            }
        }
        dy[N + 1] = Math.max(dy[N + 1], dy[N]);

        System.out.println(dy[N + 1]);
    }
}