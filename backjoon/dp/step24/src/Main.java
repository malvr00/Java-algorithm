import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] children = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, children));
    }

    public static int solution(final int N, final int[] children) {
        int lis = 0;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(children[j] < children[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            lis = Math.max(lis, dp[i]);
        }
        return N - lis;
    }

}