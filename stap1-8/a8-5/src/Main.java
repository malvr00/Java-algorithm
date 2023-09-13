import java.util.*;

public class Main {
    /*
        5. 동전교환
     */

    static ArrayList<Integer> ch = new ArrayList<>();
    public static int solution(int money, int[] coin) {
        // BFS
        Queue<Integer> q = new LinkedList<>();
        q.offer(money);

        int l = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int s = 0; s < qSize; s++) {
                int nowMoney = q.poll();
                for (int i = 0; i < coin.length; i++) {
                    int nextMoney = nowMoney - coin[i];
                    if (nextMoney == 0) {
                        return l + 1;
                    }
                    if (!ch.contains(nextMoney)) {
                        ch.add(nextMoney);
                        q.offer(nextMoney);
                    }
                }
            }
            l++;
        }
        return 0;
    }

    static int n2 = 0 , m2 = 0, answer=Integer.MAX_VALUE;
    public static void DFS(int l, int sum, Integer[] arr) {
        if(sum > m2 || l >= answer) return;
        if (sum == m2) {
            answer = Math.min(answer, l);
        } else {
            for (int i = arr.length - 1; i < n2; i++) {
                DFS(l + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();   // n2
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = kb.nextInt();
        }
        int money = kb.nextInt();   // m2
        System.out.println(solution(money, coin));
//        Arrays.sort(arr, Collections.reverseOrder());
//        DFS(0, 0, arr);
//        System.out.println(answer);
    }
}