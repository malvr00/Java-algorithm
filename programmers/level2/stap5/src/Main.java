import java.util.*;

public class Main {

    /**
     * Level2.
     * 무인도 여행 (DFS)
     */

    static int x = 0;
    static int y = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int sumVal = 0;
    static char[][] castMap;

    public static void DFS(int argX, int argY) {
        for (int i = 0; i < dx.length; i++) {
            int nX = argX + dx[i];
            int nY = argY + dy[i];
            if (nX >= 0 && nX < x && nY >= 0 && nY < y && castMap[nY][nX] != 'X') {
                sumVal += Character.getNumericValue(castMap[nY][nX]);
                castMap[nY][nX] = 'X';
                DFS(nX, nY);
            }
        }
    }

    public static int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();
        x = maps[0].length();
        y = maps.length;
        castMap = new char[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                castMap[i][j] = maps[i].charAt(j);
            }
        }

        for (int mapY = 0; mapY < y; mapY++) {
            for (int mapX = 0; mapX < x; mapX++) {
                char mapInfo = castMap[mapY][mapX];
                if (mapInfo != 'X') {
                    sumVal += Character.getNumericValue(mapInfo);
                    castMap[mapY][mapX] = 'X';
                    DFS(mapX, mapY);
                    answerList.add(sumVal);
                    sumVal = 0;
                }
            }
        }

        Collections.sort(answerList);

        int[] answer = {-1};
        if (answerList.size() != 0) {
            answer = new int[answerList.size()];
            for (int i = 0; i < answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
                        maps                         result
            ["X591X","X1X5X","X231X", "1XXX1"]      [1,1,27]
            ["XXX","XXX","XXX"]	                    [-1]
         */
        String[] maps = {"XXX","XXX","XXX"};

        solution(maps);
    }
}