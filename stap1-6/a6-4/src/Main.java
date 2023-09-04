import java.util.*;

public class Main {
    /*
        4. LRU
     */

    public static Object[] solution(int n, int m, int[] arr) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            int tmp = 0;
            int sam = 0;
            if (q.contains(arr[i])) {
                int cnt = q.size();
                while (cnt > 0) {
                    tmp = q.poll();
                    if (arr[i] == tmp) {
                        sam = tmp;
                    } else {
                        q.add(tmp);
                    }
                    cnt--;
                }
                q.add(sam);
            } else {
                if (q.size() == n) {
                    q.poll();
                    q.add(arr[i]);
                } else {
                    q.add(arr[i]);
                }
            }
        }
        Object[] answer = q.toArray();
        return answer;
    }

    public static int[] solution2(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (x == cache[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] p = new int[m];

        for (int i = 0; i < m; i++) {
            p[i] = kb.nextInt();
        }
        Object[] solution = solution(n, m, p);
        for (int i = solution.length - 1; i >= 0; i--) {
            System.out.print(solution[i] + " ");
        }
//        System.out.println(solution(n, p));
    }
}