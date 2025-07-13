import java.util.*;

public class Main {

    /**
     * Level3.
     * 거스름돈
     * DP
     */

    public int solution(int n, int[] money) {
        final int MAX = 1_000_000_007;

        int[] dy = new int[n + 1];

        dy[0] = 1;

        for(int coin : money) {
            for(int i = coin; i <= n; i++) {
                dy[i] = (dy[i] + dy[i - coin]) % MAX;
            }
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Main m = new Main();

        int n = 5;
        int[] money = {1, 2, 5};

        System.out.println(m.solution(n, money));
    }
}