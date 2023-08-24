import java.util.*;

public class Main {
    /*
        5. 연속된 자연수의 합(two pointers)
     */

    public static int solution(int n) {
        int result = 0, sum = 0, p1 = 1;

        for (int i = 1; i < n; i++) {
            sum += i;
            if (sum == n) {
                result++;
            }
            while (sum > n) {
                sum -= p1;
                p1++;
                if (sum == n) {
                    result++;
                }
            }
        }

        return result;
    }

    public static int solution2(int n) {
        int result = 0, sum = 0, lt = 1;
        int m = n / 2 + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                result++;
            }
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    result++;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        System.out.println(solution(n));
    }
}