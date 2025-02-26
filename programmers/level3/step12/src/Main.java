import java.util.*;

public class Main {

    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;

        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }

        if (alp >= maxAlp && cop >= maxCop) {
            return 0;
        }
        if (alp >= maxAlp) {
            alp = maxAlp;
        }
        if (cop >= maxCop) {
            cop = maxCop;
        }

        int[][] dy = new int[maxAlp + 2][maxCop + 2];

        for (int[] ints : dy) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dy[alp][cop] = 0;

        // [i]: 구해야하는 알고력
        // [j]: 구해야하는 코딩력
        // [i][j]: 베이스 기준 필요 시간
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dy[i + 1][j] = Math.min(dy[i + 1][j], dy[i][j] + 1);
                dy[i][j + 1] = Math.min(dy[i][j + 1], dy[i][j] + 1);

                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if(i < alpReq || j < copReq) continue;

                    if (i + alpRwd > maxAlp && j + copRwd > maxCop) {
                        dy[maxAlp][maxCop] = Math.min(dy[maxAlp][maxCop], dy[i][j] + cost);
                    } else if (i + alpRwd > maxAlp) {
                        dy[maxAlp][j + copRwd] = Math.min(dy[maxAlp][j + copRwd], dy[i][j] + cost);
                    } else if (j + copRwd > maxCop) {
                        dy[i + alpRwd][maxCop] = Math.min(dy[i + alpRwd][maxCop], dy[i][j] + cost);
                    } else if(i + alpRwd <= maxAlp && j + copRwd <= maxCop) {
                        dy[i + alpRwd][j + copRwd] = Math.min(dy[i + alpRwd][j + copRwd], dy[i][j] + cost);
                    }
                }
            }
        }

        return dy[maxAlp][maxCop];
    }

    public static void main(String[] args) {
        Main T = new Main();
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};

        System.out.println(T.solution(alp, cop, problems));
    }
}