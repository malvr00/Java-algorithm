import java.util.*;

public class Main {

    /**
     * Level2.
     * 숫자 변환하기 ( BFS )
     */

    public static int solution(int x, int y, int n) {
        int answer = 0;
        int[] ch = new int[1000001];
        Queue<Integer> q = new LinkedList<>();

        if (x == y) {
            return answer;
        }

        q.add(x);

        while (!q.isEmpty()) {
            int qSize = q.size();
            answer++;

            for (int i = 0; i < qSize; i++) {
                int val = q.poll();
                for (int j = 2; j <= 4; j++) {
                    int num = j < 4 ? val * j : val + n;
                    if (num == y) {
                        return answer;
                    }
                    if (num < y && ch[num] == 0) {
                        ch[num] = num;
                        q.add(num);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /*
            x   y   n
            10	40	5
            10	40	30
            2	5	4
         */

        int x = 10, y = 40, n = 2;
        System.out.println(solution(x ,y ,n));
    }
}