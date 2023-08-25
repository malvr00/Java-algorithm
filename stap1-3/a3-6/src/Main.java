import java.util.*;

public class Main {
    /*
        6. 최대 길이 연속부분수열(복합적 문제)
     */

    public static int solution(int n, int m, int[] arr) {
        int result = 0, p1 = 0, sum = 0, count = m;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                sum++;
            } else {
                if (count > 0) {
                    if (count == m) {
                        p1 = i;
                    }
                    count--;
                    sum++;
                } else {
                    i = p1;
                    count = m;
                    if (result < sum) {
                        result = sum;
                    }
                    sum = 0;
                }
            }
        }
        return result;
    }

    public static int solution2(int n, int k, int[] arr) {
        int result = 0, cnt = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }

            result = Math.max(result, rt - lt + 1);
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

        System.out.println(solution(n, m, arr1));
    }
}