import java.util.*;

public class Main {
    /**
     * Level 3
     * [2023 KAKAO BLIND RECRUITMENT] 미로 탈출 명령어
     * Manhattan, GREEDY, BFS
     */

    final String IMPOSSIBLE = "impossible";

    static public class Node {
        int x;
        int y;
        StringBuilder builder;

        public Node(int x, int y, StringBuilder builder) {
            this.x = x;
            this.y = y;
            this.builder = builder;
        }
    }

    public int manhattan(int x, int y, int xx, int yy) {
        return Math.abs(x - xx) + Math.abs(y - yy);
    }
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        x -= 1;
        y -= 1;
        r -= 1;
        c -= 1;

        final int[] X = {1, 0, 0, -1};
        final int[] Y = {0, -1, 1, 0};
        final char[] cArr = {'d', 'l', 'r', 'u'};

        if(manhattan(x, y, r, c) > k) return IMPOSSIBLE;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, new StringBuilder()));

        while (!q.isEmpty()) {
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Node node = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nX = X[j] + node.x;
                    int nY = Y[j] + node.y;

                    if(nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                    StringBuilder builder = new StringBuilder(node.builder.toString());
                    builder.append(cArr[j]);
                    if(manhattan(nX, nY, r, c) > (k - builder.length())) continue;

                    if (builder.length() < k) {
                        q.offer(new Node(nX, nY, new StringBuilder(builder)));
                        break;
                    } else {
                        if ((nX == r && nY == c)) {
                            return builder.toString();
                        }
                    }
                }
            }
        }

        return IMPOSSIBLE;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int n = 3, m = 4, x = 2, y = 3, r = 3, c = 1, k = 5;
        System.out.println(T.solution(n, m, x, y, r, c, k));
    }
}