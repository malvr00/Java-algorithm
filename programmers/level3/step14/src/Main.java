import java.util.*;

public class Main {

    /**
     * Level3.
     * 아이템 줍기
     * 핵심. 테두리'만' 채우기 + 이동할 시 map 상에서 변이 붙어있는 경우
     * BFS
     */

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        boolean[][] ch = new boolean[101][101];
        final int[] X = {0, 1, 0, -1};
        final int[] Y = {-1, 0, 1, 0};

        // 시작 - 도착 좌표 범위 2 배 증가
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for (int[] rect : rectangle) {
            // 사각형 범위 2 배 증가
            for(int i = 0; i < 4; i++) rect[i] *= 2;

            int startY = rect[1];
            int endY = rect[3];
            int startX = rect[0];
            int endX = rect[2];

            for (int y = startY; y <= endY; y++) {
                for (int x = startX; x <= endX; x++) {
                    // (중요) 테두리 채우기
                    if (y == startY || y == endY || x == startX || x == endX) {
                        if(map[y][x] == 2) continue;
                        map[y][x] = 1;
                    } else {
                        map[y][x] = 2;
                    }
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(characterX, characterY, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == itemX && node.y == itemY) {
                answer = node.count / 2;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nX = node.x + X[i];
                int nY = node.y + Y[i];

                if (nY < 1 || nY > 100 || nX < 1 || nX > 100) continue;

                if (!ch[nY][nX] && map[nY][nX] == 1) {
                    ch[nY][nX] = true;
                    queue.offer(new Node(nX, nY, node.count + 1));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        int characterX = 9,	characterY = 7,	itemX = 6, itemY = 1;

        int answer = m.solution(rectangle, characterX, characterY, itemX, itemY);

        System.out.println(answer);
    }
}