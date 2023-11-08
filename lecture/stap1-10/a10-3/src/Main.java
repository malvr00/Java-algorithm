import java.util.*;

public class Main {

    static int[] dy;

    /*
        3. 최대부분증가수열(LIS)
     */
    public static int solution(int n, int[] arr) {
        int cnt = arr[1];
        dy[0] = 1;

        for (int i = 1; i < n; i++) {
            if (cnt < arr[i]) {
                dy[i] = dy[i - 1] + 1;
            } else {
                dy[i] = dy[i - 1];
            }
            cnt = arr[i];
        }
        return dy[n];
    }

    public static int solution2(int[] arr) {
        int answer = 0;

        dy[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        dy = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(solution2(arr));
    }
}