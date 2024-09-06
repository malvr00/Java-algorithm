import java.util.*;

public class Main {

    public int solution(int n, int[] stairs) {
        int[] dy = new int[n + 1];
        dy[1] = stairs[1];
        if(n > 1) dy[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 3] + stairs[i - 1] + stairs[i], dy[i - 2] + stairs[i]);
        }

        return dy[n];
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = kb.nextInt();
        }

        int answer = main.solution(n, stairs);
        System.out.print(answer);
    }
}