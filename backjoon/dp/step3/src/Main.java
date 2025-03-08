import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * 실버 3
     * 1, 2, 3 더하기
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            solution(values[i]);
        }
    }

    public static void solution(int val) {
        if(val <= 1) {
            System.out.println(0);
            return;
        }

        int[] dy = new int[val + 1];
        dy[0] = 1;
        dy[1] = 1;

        for (int i = 2; i < dy.length; i++) {
            dy[i] += dy[i - 1];
            dy[i] += dy[i - 2];

            if (i - 3 >= 0) {
                dy[i] += dy[i - 3];
            }
        }

        System.out.println(dy[val]);
    }
}