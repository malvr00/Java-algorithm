import java.util.*;

public class Main {
    /*
        6. 공주구하기
     */

    public static int solution(int n, int k) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> num = new HashMap<>();


        for (int i = 1; i <= n; i++) {
            num.put(i, 0);
        }

        int i = 0;
        int cnt = 0;
        while (stack.size() < n) {
            i++;
            if (i > n) {
                i = 1;
            }
            if (num.get(i) == 1) {
                continue;
            }
            cnt++;
            if (k == cnt) {
                stack.push(i);
                num.put(i, 1);
                cnt = 0;
            }
        }
        answer = stack.pop();

        return answer;
    }

    public static int solution2(int n, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
            if (q.size() == 1) {
                answer = q.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(solution(n, k));
    }
}