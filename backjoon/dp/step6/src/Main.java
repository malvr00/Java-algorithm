import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 실버 2
     * 가장 긴 감소하는 부분 수열
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        solution(N, values);
    }

    public static void solution(int n, int[] scores) {
        // 10 30 10 20 20 10
        int answer = 0;
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            dy[i] = 1;
            for (int j = 0; j < i; j++) {
                if(scores[i] < scores[j]) dy[i] = Math.max(dy[i], dy[j] + 1);
            }

            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }

}