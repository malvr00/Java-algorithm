import java.util.*;


public class Main {
    /*
        1. 합이 같은 부분집합
     */

    static String answer = "NO";
    static List<Integer> sumList = new ArrayList<>();
    static int[] ch;
    public static void solution(int lv, int[] arr) {
        // DFS
        // 틀림: 두 개를 나눈 부분집합의 합의 비교가아닌 부분집합 하나에 전체를 비교해서 오답.
        if (answer.equals("YES")) {
            return;
        }
        if (lv == arr.length) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 1) {
                    sum += arr[i];
                }
            }
            if (sumList.contains(sum)) {
                answer = "YES";
            }

            sumList.add(sum);
        } else {
            ch[lv] = 1;
            solution(lv + 1, arr);
            ch[lv] = 0;
            solution(lv + 1, arr);
        }

    }

    static String answer2 = "NO";
    static int n, total = 0;
    static boolean flag = false;
    public static void DFS(int l, int sum, int[] arr) {
        if(flag) return;
        if(sum > total/2) return;
        if (l == n) {
            if ((total - sum) == sum) {
                answer2 = "YES";
                flag = true;
            }

        } else {
            DFS(l + 1, sum + arr[l], arr);
            DFS(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        int[] arr = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }

        solution(0, arr);

        System.out.println(answer);
    }
}