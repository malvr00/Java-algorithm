import java.util.*;

public class Main {

    /**
     * 강의
     * 청소 ( 시뮬레이션 & 구현 )
     */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int pos;

    public int[] solution(int[][] board, int k){
        // 내 풀이
        int[] answer = new int[2];
        pos = 1;

        k++;
        int y = 0;
        int x = 0;
        while (true) {
            k--;

            if (k == 0) {
                answer[0] = y;
                answer[1] = x;
                break;
            }

            boolean flag = false;
            int cnt = 0;
            for (; pos < dx.length; pos++) {
                cnt++;
                int nx = x + dx[pos];
                int ny = y + dy[pos];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length && board[ny][nx] == 0) {
                    flag = true;
                    y = ny;
                    x = nx;
                    break;
                }
                k--;
                if (pos == dx.length - 1) {
                    pos = -1;
                }
                if (cnt == 5 || k == 0) {
                    break;
                }
            }
            if (!flag) {
                answer[0] = y;
                answer[1] = x;
                break;
            }
        }

        return answer;
    }

    public int[] solution2(int[][] board, int k){
        // 강의
        int[] answer = new int[2];
        int n = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1, count = 0;
        while(count < k){
            count++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1){
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}