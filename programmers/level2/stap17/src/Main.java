import java.util.*;

public class Main {

    /**
     * Level2.
     * 양궁대회 ( KAKAO )
     */
    static int[] answer = {-1};
    static int maxPoint = 0;
    static int point = 0;

    public static void DFS(int lv, int n, int arrow, int[] player, int[] opponent) {
        if (lv == n) {
            int[] scoreInfo = score(player, opponent);
            if (scoreInfo[0] > scoreInfo[1]) {
                int num = scoreInfo[0] - scoreInfo[1];
                if (point < num) {
                    // 점수 차 가 이전 점수 차 보다 클 때
                    point = num;
                    maxPoint = scoreInfo[0];
                    answer = player.clone();
                } else if (point == num) {
                    // 점수 차 가 같을 때
                    if (maxPoint < scoreInfo[0]) {
                        // 점수 차는 같지만 획득 점수는 이전 점수보다 많을 때
                        maxPoint = scoreInfo[0];
                        answer = player.clone();
                    } else if (maxPoint == scoreInfo[0]) {
                        // 점수 차도 같고 최대 획득 점수도 같을 때 낮은 점수를 더 많이 맞춘 경우
                        if (minScore(answer, player)) {
                            answer = player.clone();
                        }
                    }
                }
            }
        } else {
            for (int i = arrow; i < player.length; i++) {
                if (player[i] <= opponent[i]) {
                    player[i]++;
                    DFS(lv + 1, n, i, player, opponent);
                    player[i]--;
                }
            }
        }
    }

    public static int[] score(int[] playerInfo, int[] opponentInfo) {
        /*
            scoreInfo[0]: player
            scoreInfo[1]: opponent
         */
        int[] scoreInfo = new int[2];
        for (int i = 0; i < playerInfo.length; i++) {
            if (playerInfo[i] > 0 || opponentInfo[i] > 0) {
                if (playerInfo[i] <= opponentInfo[i]) {
                    scoreInfo[1] += 10 - i;
                } else {
                    scoreInfo[0] += 10 - i;
                }
            }
        }
        return scoreInfo;
    }

    public static boolean minScore(int[] nowPlayerInfo, int[] postPlayerInfo) {
        for (int i = nowPlayerInfo.length - 1; i >= 0; i--) {
            if (postPlayerInfo[i] > nowPlayerInfo[i]) {
                return true;
            }
        }
        return false;
    }

    public int[] solution(int n, int[] info) {
        int[] player = new int[11];

        DFS(0, n, 0, player, info);

        return answer;
    }

    public static void main(String[] args) {
        /*
            n	info	                    result
            5	[2,1,1,1,0,0,0,0,0,0,0]	    [0,2,2,0,1,0,0,0,0,0,0]
            1	[1,0,0,0,0,0,0,0,0,0,0]	    [-1]
            9	[0,0,1,2,0,1,1,1,1,1,1]	    [1,1,2,0,1,2,2,0,0,0,0]
            10	[0,0,0,0,0,0,0,0,3,4,3]	    [1,1,1,1,1,1,1,1,0,0,2]
         */

        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        Main main = new Main();
        int[] solution = main.solution(n, info);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}