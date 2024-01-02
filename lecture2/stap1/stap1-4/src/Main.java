import java.util.*;

public class Main {
    /**
     * 강의.
     * 좌석 번호 ( 시뮬레이션 & 구현 )
     */
    public int[] solution(int c, int r, int k){
        /*
            내 풀이
         */
        int[] answer = new int[2];
        int[][] map = new int[r][c];
        int row = r - 1;
        int column = 0;
        int cnt = 0;
        int pos = 0;
        int r2 = 0;

        if ((c * r) < k) {
            return answer;
        }

        while (cnt < k) {
            if (pos == 0) {
                while (row >= r2 && cnt < k) {
                    map[row][column] = 1;
                    cnt++;
                    row--;
                }
                row++;
                if (cnt < k) {
                    column++;
                    r2++;
                }
            } else if (pos == 1) {
                while (column < c && cnt < k) {
                    map[row][column] = 1;
                    cnt++;
                    column++;
                }
                column--;
                if (cnt < k) {
                    row++;
                    c--;
                }
            } else if (pos == 2) {
                while (row < r && cnt < k) {
                    map[row][column] = 1;
                    cnt++;
                    row++;
                }
                row--;
                if (cnt < k) {
                    column--;
                    r--;
                }
            } else if (pos == 3) {
                while (column >= r2 && cnt < k) {
                    map[row][column] = 1;
                    cnt++;
                    column--;
                }
                column++;
                if (cnt < k) {
                    row--;
                }
            }
            pos = (pos + 1) % 4;
        }

        answer[0] = column + 1;
        answer[1] = row + 1;

        return answer;
    }

    public int[] solution(int c, int r, int k, int version) {
        /*
            강의
         */
        int[] answer = new int[2];
        if (k > c * r) return new int[]{0, 0};
        int[][] seat = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0, y = 0, count = 1, d = 1;
        while (count < k) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] > 0) {
                d = (d + 1) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }
        answer[0] = x + 1;
        answer[1] = y + 1;
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(6, 5, 12, 2)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}