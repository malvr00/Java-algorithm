import java.util.Arrays;
import java.util.Stack;

public class Main {

    /**
     * Level3
     * 표 편집 (2021 카카오 채용연계형 인턴십)
     * 이중 연결 리스트
     */
    public void solution(int n, int k, String[] cmd) {
        int[] prev = new int[n], next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n-1] = -1;

        Stack<Integer> stk = new Stack<>();
        int cur = k;

        for (String c : cmd) {
            char op = c.charAt(0);
            if (op == 'U' || op == 'D') {
                int X = Integer.parseInt(c.substring(2));
                for (int i = 0; i < X; i++) {
                    cur = (op == 'U') ? prev[cur] : next[cur];
                }
            } else if (op == 'C') {
                stk.push(cur);
                // 연결 끊기
                if (prev[cur] != -1) next[prev[cur]] = next[cur];
                if (next[cur] != -1) prev[next[cur]] = prev[cur];
                // 새 선택
                cur = (next[cur] != -1) ? next[cur] : prev[cur];
            } else { // Z
                int x = stk.pop();
                if (prev[x] != -1) next[prev[x]] = x;
                if (next[x] != -1) prev[next[x]] = x;
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, 'O');
        while (!stk.isEmpty()) {
            ans[stk.pop()] = 'X';
        }
        System.out.println(new String(ans));
//        return builder.toString();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solution(8, 1, new String[]{"C"});
    }
}