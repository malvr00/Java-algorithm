import java.util.*;

public class Main {

    public int solution(int D, int[][] pipes) {
        int[] dy = new int[D + 1];

        for (int i = 0; i < pipes.length; i++) {
            for (int j = D; j >= pipes[i][0]; j--) {
                if (dy[j - pipes[i][0]] == 0) {
                    continue;
                }
                dy[j] = Math.max(dy[j], Math.min(dy[j - pipes[i][0]], pipes[i][1]));
            }
            dy[pipes[i][0]] = Math.max(dy[pipes[i][0]], pipes[i][1]);
        }

        return dy[D];
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);

        int D = kb.nextInt();
        int P = kb.nextInt();

        int[][] pipes = new int[P][2];

        for (int i = 0; i < P; i++) {
            pipes[i][0] = kb.nextInt();
            pipes[i][1] = kb.nextInt();
        }

        System.out.print(main.solution(D, pipes));
    }
}