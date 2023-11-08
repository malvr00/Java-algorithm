import java.util.*;


class Node {
    int point;
    int time;
}
public class Main {
    /*
        3. 최대점수 구하기
     */

    static int answer = 0;
    public static void solution(int lv, int timeSum, int pointSum, int maxTime, Node[] arr) {
        // DFS
        if (timeSum > maxTime) {
            return;
        }
        if (lv == arr.length) {
            answer = Math.max(answer, pointSum);
        } else {
            solution(lv + 1, timeSum + arr[lv].time, pointSum + arr[lv].point, maxTime, arr);
            solution(lv + 1, timeSum, pointSum, maxTime, arr);
        }

    }

    static int n2 = 0, answer2 = 0, m2 = 0;
    public static void DFS(int l, int sum, int time, int[] ps, int[] pt) {
        if(time > m2) return;
        if (l == n2) {
            answer = Math.max(answer, sum);
        } else {

            DFS(l + 1, sum + ps[l], time + pt[l], ps, pt);
            DFS(l + 1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();   // n2
        int m = kb.nextInt();   // m2
        Node[] arr = new Node[n];

        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.point = kb.nextInt();
            node.time = kb.nextInt();
            arr[i] = node;
        }

        solution(0, 0, 0, m, arr);

        System.out.println(answer);
    }
}