public class Main {

    /**
     * Level3.
     * 자물쇠와 열쇠
     * 구현
     */

    public int[][] copyArr(int[][] arr) {
        int[][] newArr = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }

        return newArr;
    }

    // 90도 회전
    public int[][] rotate90(int[][] key) {
        int[][] newKey = new int[key.length][key.length];

        for (int x = 0; x < key.length; x++) {
            for (int y = 0; y < key.length; y++) {
                newKey[y][key.length - x - 1] = key[x][y];
            }
        }

        return newKey;
    }

    // 열쇠구멍 맞추기
    public boolean check(int[][] key, int[][] board, int x, int y, int N, int M) {
        int[][] copy = copyArr(board);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                copy[i + x][j + y] += key[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 0 or 2 이상 일 경우 열쇠 구멍 안 맞음
                if(copy[i + M - 1][j + M - 1] != 1) return false;
            }
        }

        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length, N = lock.length;
        int size = N + 2 * (M - 1);
        // key 최악의 이동 수 까지 배열 증가
        int[][] board = new int[size][size];

        // 중앙에 lock 값 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        // 90도 4 방향
        for (int i = 0; i < 4; i++) {
            key = rotate90(key);
            // key 전체를 움직이기 때문에 'size - M'
            for (int x = 0; x <= size - M; x++) { // 전체 아래로 이동
                for (int y = 0; y <= size - M; y++) { // 전체 오른쪽으로 이동
                    if(check(key, board, x, y, N, M)) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(m.solution(key, lock));
    }
}