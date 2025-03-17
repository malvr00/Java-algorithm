import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        solution(str1, str2);
    }

    public static void solution(String str1, String str2) {
        final int N = str1.length();
        final int M = str2.length();

        // [str1 문자열][str2 문자열]
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            char a = str1.charAt(i - 1);
            for (int j = 1; j <= M; j++) {
                char b = str2.charAt(j - 1);
                // i - 1 위치를 제외한 str1 문자와 j - 1 위치를 제외한 str2 문자의 LCS 구한 길이 + 1
                if(a == b) dp[i][j] = dp[i - 1][j - 1] + 1;
                // b 문자열을 제외한 str1, a 문자열을 제외한 str2 중 더 긴 LCS 길이
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // LCS 길이
        System.out.println(dp[N][M]);

        // i = str1, j = str2
        int i = N, j = M;
        StringBuilder builder = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                builder.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i - 1][j] <= dp[i][j - 1]) j--;
                else i--;
            }
        }

        System.out.println(builder.reverse());
    }
}