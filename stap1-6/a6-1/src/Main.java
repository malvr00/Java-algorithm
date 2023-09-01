import java.util.*;

public class Main {
    /*
        1. 선택 정렬
     */

    public static int[] solution(int n, int[] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public static int[] solution2(int n, int m, int[] arr) {
//        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = kb.nextInt();
        }
        int[] solution = solution(n, p);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
//        System.out.println(solution(n, p));
    }
}