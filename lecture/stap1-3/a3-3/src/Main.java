import java.util.*;

public class Main {
    /*
        3. 최대 매출(Sliding window)
     */

    public static int solution(int n, int[] arr1, int m) {
        int result = 0;
        int p1 = 0, searchIndex;

        while (p1 < n) {
            int mMax = 0;
            if (p1 + m < n) {
                searchIndex = p1 + m;
            } else {
                break;
            }
            for (int i = p1; i < searchIndex; i++) {
                mMax += arr1[i];
            }
            if (result < mMax) {
                result = mMax;
            }
            p1++;
        }

        return result;
    }

    public static int solution2(int n, int[] arr1, int m) {
        int result = 0;

        int startIdx, sum = 0;
        for (startIdx = 0; startIdx < m; startIdx++) {
            sum += arr1[startIdx];
        }
        result = sum;
        for (; startIdx < n; startIdx++) {
            sum += arr1[startIdx];
            sum -= arr1[startIdx - m];
            if (result < sum) {
                result = sum;
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