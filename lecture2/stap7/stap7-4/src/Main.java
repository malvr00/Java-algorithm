import java.util.*;

public class Main {
    public int solution(int[][] board){
        int answer = 0;
        final int[] X = {-1, 0, 1, 0};
        final int[] Y = {0, 1, 0, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int j = 0; j < X.length; j++) {
                    int nX = X[j] + point[0];
                    int nY = Y[j] + point[1];
                    if (nX == 6 && nY == 6) {
                        return answer;
                    }

                    if (nX >= 0 && nX < board.length && nY >= 0 && nY < board.length && board[nX][nY] != 1) {
                        board[nX][nY] = 1;
                        q.offer(new int[]{nX, nY});
                    }
                }
            }
        }

        return -1;
    }

    public int solution(int[][] board){
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> Q = new LinkedList<>();
        int[][] dist = new int[7][7];
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            L++;
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();
                for(int k = 0; k < 4; k++){
                    int nx=p[0]+dx[k];
                    int ny=p[1]+dy[k];
                    if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        Q.offer(new int[]{nx, ny});
                        dist[nx][ny] = L;
                    }
                }
            }
        }
        if(dist[6][6]==0) return -1;
        else return dist[6][6];
    }

    public static void main(String[] args){
        Main T = new Main();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        int[][] arr2 = {{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0}};

        System.out.println(T.solution(arr));
    }
}