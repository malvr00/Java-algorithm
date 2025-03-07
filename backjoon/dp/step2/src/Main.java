import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * 실버 3.
     * 1로 만들기
     */

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dy = new int[N + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);

        dy[0] = 0;
        dy[1] = 0;

        for (int i = 2; i <= N; i++) {
            // 나누기 3
            if(i % 3 == 0) {
                dy[i] = Math.min(dy[i], dy[i / 3] + 1);
            }
            // 나누기 2
            if(i % 2 == 0) {
                dy[i] = Math.min(dy[i], dy[i / 2] + 1);
            }

            // 빼기 1
            dy[i] = Math.min(dy[i], dy[i - 1] + 1);
        }

        System.out.println(dy[N]);
    }
}