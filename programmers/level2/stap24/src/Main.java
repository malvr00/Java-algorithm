import java.util.*;

class Point {
    int x;
    int y;
    int stdX;
    int stdY;

    public Point(int x, int y, int stdX, int stdY) {
        this.x = x;
        this.y = y;
        this.stdX = stdX;
        this.stdY = stdY;
    }
}
public class Main {

    /**
     * Level2.
     * 거리두기 확인 ( KAKAO )
     */

    static final char USER = 'P';
    static final char TABLE = 'O';
    static final char BLOCK = 'X';

    static int[] PX = {0, 1, 0, -1};
    static int[] PY = {-1, 0, 1, 0};

    public boolean BFS(String[] place, int x, int y) {
        boolean checked = true;
        final int MAX_CNT = 2;
        boolean[][] isVisit = new boolean[5][5];
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, x, y));
        isVisit[y][x] = true;

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Point point = q.poll();
                for (int j = 0; j < PX.length; j++) {
                    int nX = point.x + PX[j];
                    int nY = point.y + PY[j];
                    int weight = Math.abs(point.stdY - nY) + Math.abs(point.stdX - nX);
                    if (nX >= 0 && nX < 5 && nY >= 0 && nY < 5
                            && !isVisit[nY][nX] && place[nY].charAt(nX) != BLOCK) {
                        isVisit[nY][nX] = true;
                        switch (place[nY].charAt(nX)) {
                            case USER:
                                if (weight <= MAX_CNT) {
                                    int wX = nX - point.stdX;
                                    int wY = nY - point.stdY;
                                    int bX = wX > 0 ? nX - 1 : wX < 0 ? nX + 1 : nX;
                                    int bY = wY > 0 ? nY - 1 : wY < 0 ? nY + 1 : nY;
                                    if (wX == 0 || wY == 0) {
                                        if (bX >= 0 && bX < 5 && bY >= 0 && bY < 5
                                                && place[bY].charAt(bX) != BLOCK) {
                                            return false;
                                        }
                                    } else {
                                        if (bX >= 0 && bX < 5 && place[nY].charAt(bX) != BLOCK) {
                                            return false;
                                        }
                                        if (bY >= 0 && bY < 5 && place[bY].charAt(nX) != BLOCK) {
                                            return false;
                                        }
                                    }
                                }
                                break;
                            case TABLE:
                                q.offer(new Point(nX, nY, point.stdX, point.stdY));
                                break;
                        }
                    }
                }
            }
        }

        return checked;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        Arrays.fill(answer, 1);

        for (int i = 0; i < places.length; i++) {
            boolean flag = true;
            for (int j = 0; j < places[i].length; j++) {
                if(!flag) break;
                for (int s = 0; s < places[i][j].length(); s++) {
                    if (places[i][j].charAt(s) == USER) {
                        flag = BFS(places[i], s, j);
                        if (!flag) {
                            answer[i] = 0;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            places	                                                result
            [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],         [1, 0, 1, 1, 1]
            ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
            ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
            ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
            ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
         */
        String[][] places = {{"OOOOO", "OOPXO", "OOXPO", "OOOOO", "OOOOO"},
                {"OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        Main main = new Main();
        int[] solution = main.solution(places);

        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}