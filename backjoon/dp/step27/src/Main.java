import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strA = br.readLine();
        String strB = br.readLine();

        System.out.println(solution(strA, strB));
    }

    public static int solution(String strA, String strB) {
        final int N = strA.length();
        final int M = strB.length();

        int[][] dp = new int[N + 1][M + 1];
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            char a = strA.charAt(i - 1);
            for (int j = 1; j <= M; j++) {
                char b = strB.charAt(j - 1);

                if(a == b) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;

                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }

}