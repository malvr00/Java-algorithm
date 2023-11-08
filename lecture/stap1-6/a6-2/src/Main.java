import java.util.*;

public class Main {
    /*
        2. 버블 정렬
     */

    public static int[] solution(int n, int[] arr) {
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }

    public static int[] solution2(int n, int m, int[] arr) {
//        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n -i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
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