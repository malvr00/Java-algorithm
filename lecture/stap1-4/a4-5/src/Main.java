import java.util.*;

public class Main {
    /*
        5. K번째 큰 수
     */

    public static int solution(int n, int k, int[] arr) {
        int answer = 0, sum = 0;
        TreeSet<Integer> hs = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int s = j + 1; s < n; s++) {
                    hs.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }

        List<Integer> data = new ArrayList<>(hs);
        if (k > data.size()) {
            answer = -1;
        } else {
            answer = data.get(data.size() - k);
        }

        return answer;
    }

    public static int solution2(int n, int k, int[] arr) {
        int answer = -1;
        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int s = j + 1; s < n; s++) {
                    tSet.add(arr[i] + arr[j] + arr[s]);
                }
            }
        }

        int cnt = 0;
        for (int x : tSet) {
            cnt++;
            if (cnt == k) {
                return x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }
}