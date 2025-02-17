import java.util.*;

public class Main {

    /**
     * LEVEL 3
     * 2차원 동전 뒤집기
     * DFS
     */

    int n, m;
    int answer;
    int[][] tempTarget;

    // 열 뒤집기
    public int checkCol(int y, int[][] beginning) {
        int cnt = 0;
        for (int x = 0; x < n; x++) {
            if (beginning[x][y] == tempTarget[x][y]) {
                cnt++;
            }
        }

        if(cnt == n) return 0;
        else if(cnt == 0) return 1;
        else return -1;
    }

    // 행 뒤집기
    public void changeRow(int x, int[][] beginning) {
        for (int y = 0; y < m; y++) {
            beginning[x][y] = (beginning[x][y] + 1) % 2;
        }
    }

    // 뒤집기 게임
    public void dfs(int L, int cnt, int[][] beginning) {
        if (L == n) {
            int tempCnt = 0;
            for (int y = 0; y < m; y++) {
                int checkCnt = checkCol(y, beginning);
                if (checkCnt == -1) {
                    return;
                } else {
                    tempCnt += checkCnt;
                }
            }
            answer = Math.min(answer, cnt + tempCnt);
        } else {
            changeRow(L, beginning);    // 행 뒤집기
            dfs(L + 1, cnt + 1, beginning);
            changeRow(L, beginning);    // 행 원복
            dfs(L + 1, cnt, beginning);
        }
    }

    public int solution(int[][] beginning, int[][] target) {
        answer = Integer.MAX_VALUE;
        n = target.length;
        m = target[0].length;
        tempTarget = target;

        dfs(0, 0, beginning);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] beginning =  {{0,0,0}, {0,0,0}, {0,0,0}};
        int[][] target = {{1,0,1}, {0,0,0}, {0,0,0}};

        System.out.println(T.solution(beginning, target));
    }
}