import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * 실버 3
     * 계단 오르기
     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println(0);
            return;
        }

        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        solution(N, values);
    }

    public static void solution(final int n, final int[] points) {
        if(n == 1) {
            System.out.println(points[0]);
            return;
        }

        int[] dy = new int[n + 1];

        dy[1] = points[0];
        dy[2] = points[0] + points[1];

        for (int i = 3; i <= n; i++) {
            int nowPoint = points[i - 1];
            dy[i] = Math.max(dy[i - 3] + points[i - 2] + nowPoint, dy[i - 2] + nowPoint);
        }

        System.out.println(dy[n]);
    }
}