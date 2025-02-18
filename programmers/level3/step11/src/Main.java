import java.util.*;

public class Main {

    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] dy = new int[target + 1][2];
        // i = 목표점수, [i][0] = 다트 횟수, [i][1] = 싱글 + 불
        for (int i = 0; i < dy.length; i++) {
            dy[i][0] = Integer.MAX_VALUE;
            dy[i][1] = 0;
        }

        dy[0][0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int hitP = 1; hitP <= 20; hitP++) {
                // 싱글
                if (i - hitP >= 0) {
                    if (dy[i][0] > dy[i - hitP][0] + 1) {
                        dy[i][0] = dy[i - hitP][0] + 1;
                        dy[i][1] = dy[i - hitP][1] + 1;
                    } else if (dy[i][0] == dy[i - hitP][0] + 1) {
                        dy[i][1] = Math.max(dy[i][1], dy[i - hitP][1] + 1);
                    }
                }

                // 더블
                if (i - hitP * 2 >= 0) {
                    if (dy[i][0] > dy[i - hitP * 2][0] + 1) {
                        dy[i][0] = dy[i - hitP * 2][0] + 1;
                        dy[i][1] = dy[i - hitP * 2][1];
                    } else if (dy[i][0] == dy[i - hitP * 2][0] + 1) {
                        dy[i][1] = Math.max(dy[i][1], dy[i - hitP * 2][1]);
                    }
                }

                // 트리플
                if (i - hitP * 3 >= 0) {
                    if (dy[i][0] > dy[i - hitP * 3][0] + 1) {
                        dy[i][0] = dy[i - hitP * 3][0] + 1;
                        dy[i][1] = dy[i - hitP * 3][1];
                    } else if (dy[i][0] == dy[i - hitP * 3][0] + 1) {
                        dy[i][1] = Math.max(dy[i][1], dy[i - hitP * 3][1]);
                    }
                }

                // 불
                if (i - 50 >= 0) {
                    if (dy[i][0] > dy[i - 50][0] + 1) {
                        dy[i][0] = dy[i - 50][0] + 1;
                        dy[i][1] = dy[i - 50][1] + 1;
                    } else if (dy[i][0] == dy[i - 50][0] + 1) {
                        dy[i][1] = Math.max(dy[i][1], dy[i - 50][1] + 1);
                    }
                }
            }
        }

        answer[0] = dy[target][0];
        answer[1] = dy[target][1];

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(21)));
    }
}