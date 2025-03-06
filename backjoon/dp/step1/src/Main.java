import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 브론즈 1
     * 피보나치 수 2
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long[] dy = new long[n + 2];

        dy[0] = 0;
        dy[1] = 1;

        for(int i = 2; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        System.out.print(dy[n]);
    }
}