import java.util.*;

public class Main {
    public int solution(int[][] board){
        final int[] X = {-1, 0, 1, 0};
        final int[] Y = {0, 1, 0, -1};

        List<int[]> building = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    building.add(new int[]{i, j});
                }
            }
        }

        int[][][] disk = new int[building.size()][board.length][board.length];

        for (int i = 0; i < building.size(); i++) {
            int cnt = 0;
            Queue<int[]> q = new LinkedList<>();

            int x = building.get(i)[0];
            int y = building.get(i)[1];

            disk[i][x][y] = 2501;
            q.offer(new int[]{x, y});

            while (!q.isEmpty()) {
                cnt++;
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int[] poll = q.poll();
                    for (int m = 0; m < X.length; m++) {
                        int nX = X[m] + poll[0];
                        int nY = Y[m] + poll[1];

                        if (nX >= 0 && nX < board.length && nY >= 0 && nY < board.length
                                && (board[nX][nY] == 0 && disk[i][nX][nY] == 0)) {
                            q.offer(new int[]{nX, nY});
                            disk[i][nX][nY] = cnt;
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                int sum = 0;
                for (int i = 0; i < building.size(); i++) {
                    if (disk[i][x][y] == 0) {
                        sum = 0;
                        break;
                    } else {
                        sum += disk[i][x][y];
                    }
                }
                if (sum > 0) {
                    answer = Math.min(answer, sum);
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        } else {
            return answer;
        }
    }


    public int solution(int[][] board, int version){
        int answer = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int[][] dist = new int[n][n];
        Queue<int[]> Q = new LinkedList<>();
        int emptyLand = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    answer = Integer.MAX_VALUE;
                    Q.offer(new int[]{i, j});
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        int len = Q.size();
                        for(int r = 0; r < len; r++){
                            int[] cur = Q.poll();
                            for(int k = 0; k < 4; k++){
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == emptyLand){
                                    board[nx][ny]--;
                                    dist[nx][ny] += L;
                                    Q.offer(new int[]{nx, ny});
                                    answer = Math.min(answer, dist[nx][ny]);
                                }
                            }
                        }
                    }
                    emptyLand--;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}, 2));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
    }
}