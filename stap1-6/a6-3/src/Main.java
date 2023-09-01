import java.util.*;

public class Main {
    /*
        2. 삽입 정렬
     */

    public static int[] solution(int n, int[] arr) {
        int answer = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    public static int[] solution2(int n, int[] arr) {
//        int answer = 0;
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
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
        int[] solution = solution2(n, p);
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i] + " ");
        }
//        System.out.println(solution(n, p));
    }
}