import java.util.*;

public class Main {
    /*
        4. 연속부분수열(복합적 문제)
     */

    public static int solution(int n, int[] arr1, int m) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr1[j];
                if (sum == m) {
                    result++;
                    break;
                } else if (sum > m) {
                    break;
                }
            }
        }
        return result;
    }

    public static int solution2(int n, int[] arr1, int m) {
        int result = 0;
        int p1 = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr1[i];

            if (sum == m) {
                result++;
            }
            while (sum >= m) {
                sum -= arr1[p1++];
                if (sum == m) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }


        System.out.println(solution2(n, arr1, m));
    }
}