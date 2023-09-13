import java.util.*;


public class Main {
    /*
        2. 바둑이 승차(DFS)
     */

    static int answer = 0;
    public static void solution(int lv, int sum, int[] arr, int w) {
        // DFS
        if (lv == arr.length) {
            if (answer < sum) {
                if (sum <= w) {
                    answer = sum;
                }
            }

        } else {
            solution(lv + 1, sum + arr[lv], arr, w);
            solution(lv + 1, sum, arr, w);
        }
    }

    static int answer2 = 0, c2, n2;
    public static void DFS(int l, int sum, int[] arr) {
        if(sum > c2) return;
        if (l == n2) {
            answer2 = Math.max(answer, sum);
        } else {
            DFS(l + 1, sum + arr[l], arr);
            DFS(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int w = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        c2 = w;
        n2 = n;

        solution(0, 0, arr, w);

        System.out.println(answer);
    }
}