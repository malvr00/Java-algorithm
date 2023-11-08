import java.util.*;

public class Main {
    /*
        9. 뮤직비디오 (결정 알고리즘)
     */

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max += arr[i];
            min = Math.max(min, arr[i]);
        }
        int lt = min, rt = max;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int recode = 0;
            int recodeCnt = 0;

            for (int i = 0; i < n; i++) {
                recode += arr[i];
                if (recode > mid) {
                    recodeCnt++;
                    recode = arr[i];
                } else if (recode == mid) {
                    recodeCnt++;
                    recode = 0;
                }
            }
            if (recode > 0 && recode < mid) {
                recodeCnt++;
            }

            if (recodeCnt <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }

        return cnt;
    }
    public static int solution2(int n, int m, int[] arr) {
        int answer = 0;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}