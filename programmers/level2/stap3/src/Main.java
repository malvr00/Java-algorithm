import java.util.*;

public class Main {

    /**
     * Level2.
     * 문제: 미로 탈출 ( BFS )
     */
    static int lanX = 0;
    static int lanY = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] mapList;
    static char[][] tmpList;

    public static int BFS(int startX, int startY, int desX, int desY) {
        int cnt = 0;
        boolean flag = false;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startX);
        q.offer(startY);

        while (!q.isEmpty()) {
            if(flag) break;
            int qSize = q.size() / 2;
            cnt++;
            for (int i = 0; i < qSize; i++) {
                int x = q.poll();
                int y = q.poll();
                for (int j = 0; j < dx.length; j++) {
                    if(flag) break;
                    int nX = x + dx[j];
                    int nY = y + dy[j];

                    if (nX >= 0 && nX < lanX && nY >= 0 && nY < lanY && mapList[nY][nX] != 'X') {
                        mapList[nY][nX] = 'X';
                        if (desX == nX && desY == nY) {
                            flag = true;
                            mapList = tmpList.clone();
                            break;
                        }
                        q.offer(nX);
                        q.offer(nY);
                    }
                }
            }
        }

        if(!flag) cnt = -1;

        return cnt;
    }

    public static int solution(String[] maps) {
        int answer = 0;
        int sX = 0, sY = 0;
        int lX = 0, lY = 0;
        int eX = 0, eY = 0;
        lanY = maps.length;
        lanX = maps[0].length();
        mapList = new char[lanY][lanX];
        tmpList = new char[lanY][lanX];

        for (int i = 0; i < lanY; i++) {
            int idx = 0;
            for(char x : maps[i].toCharArray()){
                if (x == 'S') {
                    sX = idx;
                    sY = i;
                } else if (x == 'L') {
                    lX = idx;
                    lY = i;
                } else if (x == 'E') {
                    eX = idx;
                    eY = i;
                }
                mapList[i][idx] = x;
                tmpList[i][idx] = x;
                idx++;
            }
        }

        int move1 = BFS(sX, sY, lX, lY);

        if (move1 > -1) {
            int move2 = BFS(lX, lY, eX, eY);
            if (move2 > -1) {
                answer = move1 + move2;
            } else {
                answer = move2;
            }
        } else {
            answer = move1;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            S : 시작 지점
            E : 출구
            L : 레버
            O : 통로
            X : 벽
                            maps                        result
            ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]	  16
            ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]	  -1
            ["SEOLX","XXXXX","XXXXX","XXXXX","XXXXX"]      5
         */
        String[] arr = {"SEOLX","XXXXX","XXXXX","XXXXX","XXXXX"};
        System.out.println(solution(arr));
    }
}