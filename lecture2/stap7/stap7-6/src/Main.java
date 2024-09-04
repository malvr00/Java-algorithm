import java.util.*;

public class Main {

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] board){
        int answer = 0;

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};

        int R = board.length;
        int C = board[0].length;
        int[] knight = new int[2];
        int[][] copyBoard = new int[R][C];
        int[][] answerBoard = new int[R][C];
        Queue<Node> q = new LinkedList<>();
        List<Node> apple = new ArrayList<>();
        

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copyBoard[i][j] = board[i][j];
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                    copyBoard[i][j] = 0;
                    q.add(new Node(i, j));
                }
                if (board[i][j] == 3) {
                    knight[0] = i;
                    knight[1] = j;
                }
                answerBoard[i][j] = Integer.MAX_VALUE;
            }
        }

        /*
         *  산딸기 탐색
         */
        while (!q.isEmpty()) {
            answer++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node hee = q.poll();

                for (int j = 0; j < x.length; j++) {
                    int nX = hee.x + x[j];
                    int nY = hee.y + y[j];

                    if (nX >= 0 && nX < R && nY >= 0 && nY < C && board[nX][nY] != 1) {
                        switch (board[nX][nY]) {
                            case 3:
                            case 0:
                                board[nX][nY] = 1;
                                q.offer(new Node(nX, nY));
                                break;
                            case 4:
                                copyBoard[nX][nY] = 1;
                                answerBoard[nX][nY] = answer;
                                apple.add(new Node(nX, nY));
                                break;
                        }
                    }
                }
            }
        }

        /*
         *  산딸기 기준으로 기사 탐색
         */
        for (Node node : apple) {
            q.offer(node);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node ap = q.poll();
                    for (int j = 0; j < x.length; j++) {
                        int nX = ap.x + x[j];
                        int nY = ap.y + y[j];

                        if (nX >= 0 && nX < R && nY >= 0 && nY < C && copyBoard[nX][nY] != 1) {
                            if (copyBoard[nX][nY] == 0 || copyBoard[nX][nY] == 3) {
                                if (answerBoard[ap.x][ap.y] + 1 < answerBoard[nX][nY]) {
                                    if(copyBoard[nX][nY] == 0) q.offer(new Node(nX, nY));
                                    answerBoard[nX][nY] = answerBoard[ap.x][ap.y] + 1;
                                }
                            }
                        }
                    }
                }
            }
        }

        return answerBoard[knight[0]][knight[1]];
    }

    public int solution(int[][] board, int version){
        int answer = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = board.length;
        int m = board[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> Q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    Q.offer(new int[]{i, j});
                    int[][] ch = new int[n][m];
                    ch[i][j] = 1;
                    int L = 0;
                    while(!Q.isEmpty()){
                        L++;
                        int len = Q.size();
                        for(int r = 0; r < len; r++){
                            int[] cur = Q.poll();
                            for(int k = 0; k < 4; k++){
                                int nx = cur[0] + dx[k];
                                int ny = cur[1] + dy[k];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1){
                                    if(ch[nx][ny] == 0){
                                        ch[nx][ny] = 1;
                                        dist[nx][ny] += L;
                                        Q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 4 && dist[i][j] > 0){
                    answer = Math.min(answer, dist[i][j]);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 0},
                {0, 2, 1, 1, 3, 0, 4, 0},
                {0, 0, 0, 4, 1, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{
                {3, 0, 0, 0, 1, 4, 4, 4},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 4, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1, 1, 0},
                {4, 0, 0, 0, 1, 0, 0, 0},
                {4, 1, 0, 0, 1, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 1, 2}}));
        System.out.println(T.solution(new int[][]{
                {4, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 2, 3, 4},
                {0, 1, 0, 1, 0}}));
    }
}