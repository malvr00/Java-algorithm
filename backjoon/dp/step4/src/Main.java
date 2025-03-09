import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * 실버 3
     * 2xn 타일링
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }

        final int base = 10_007;

        int[] dy = new int[N + 1];
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2]) % base;
        }

        System.out.println(dy[N]);
    }
}