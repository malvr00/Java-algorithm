import java.util.*;

class Point {
    int x;
    int y;
    int move;
    int answer;
    char state;

    public Point(int x, int y, int move, int answer, char state) {
        this.x = x;
        this.y = y;
        this.move = move;
        this.answer = answer;
        this.state = state;
    }
}
public class Main {
    /**
     * 강의
     * 잃어버린 강아지 ( 시뮬레이션 & 구현 )
     */

    public int solution(int[][] board){
        /*
            내 풀이
        */
        int answer = 0;
        final int MAX = 10000;
        final int len = board.length;
        final int[] dx = {-1, 0, 1, 0};
        final int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 2) {
                    q.offer(new Point(i, j, 0, 0, 'p'));
                } else if (board[i][j] == 3) {
                    q.offer(new Point(i, j, 0, -1, 'd'));
                }

            }
        }

        while (!q.isEmpty()) {
            Point p = null;
            Point d = null;
            for (int j = 0; j < 2; j++) {
                if (q.peek().state == 'p') {
                    p = q.poll();
                } else {
                    d = q.poll();
                }
            }
            int nx = p.x + dx[p.move];
            int ny = p.y + dy[p.move];
            if (nx < 0 || nx >= len || ny < 0 || ny >= len || board[nx][ny] == 1) {
                p.answer++;
                p.move = (p.move + 1) % 4;
            } else {
                p.answer++;
                p.x = nx;
                p.y = ny;
            }

            nx = d.x + dx[d.move];
            ny = d.y + dy[d.move];
            if (nx < 0 || nx >= len || ny < 0 || ny >= len || board[nx][ny] == 1) {
                d.move = (d.move + 1) % 4;
            } else {
                d.x = nx;
                d.y = ny;
            }

            if (p.x == d.x && p.y == d.y) {
                return p.answer;
            } else if (p.answer > MAX) {
                return 0;
            }

            q.offer(p);
            q.offer(d);
        }


        return answer;
    }

    public int solution(int[][] board, int version){
        /*
            강의
        */
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    x1 = i;
                    y1 = j;
                }
                if(board[i][j] == 3){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        int d1 = 0, d2 = 0, count = 0;
        while(count < 10000){
            count++;
            int nx1 = x1 + dx[d1];
            int ny1 = y1 + dy[d1];
            int nx2 = x2 + dx[d2];
            int ny2 = y2 + dy[d2];
            boolean flag1 = true, flag2 = true;
            if(nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1){
                d1 = (d1 + 1) % 4;
                flag1 = false;
            }
            if(nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1){
                d2 = (d2 + 1) % 4;
                flag2 = false;
            }
            if(flag1 == true){
                x1 = nx1;
                y1 = ny1;
            }
            if(flag2 == true){
                x2 = nx2;
                y2 = ny2;
            }
            if(x1 == x2 && y1 == y2) break;
        }
        if(count >= 10000) return 0;
        return count;
    }
    public static void main(String[] args){
        /*
            0 -> 빈칸, 1 -> 나무
            2 -> 현수, 3 -> 강아지
         */
        Main T = new Main();
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}