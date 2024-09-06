import java.util.*;

public class Main {

    public int solution(int n, int[] score) {
        if(n == 1) return 1;
        int answer = 0;
        int[][] dy = new int[n + 1][n + 1];
        Arrays.sort(score);

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int baseCnt = 2;
                int rule = score[j] - score[i];
                for (int k = i - 1; k >= 1; k--) {
                    if (score[i] - score[k] == rule) {
                        baseCnt = Math.max(dy[k][i] + 1, baseCnt);
                        break;
                    }
                }
                dy[i][j] = baseCnt;
                answer = Math.max(answer, dy[i][j]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = kb.nextInt();
        }

        System.out.print(main.solution(n, score));
    }
}