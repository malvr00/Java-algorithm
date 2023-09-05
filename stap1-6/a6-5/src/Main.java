import java.util.*;

public class Main {
    /*
        5. 중복확인
     */

    public static String solution(int n, int[] arr) {
        String answer = "U";

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        if (set.size() != arr.length) {
            answer = "D";
        }

        return answer;
    }

    public static String solution2(int size, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);

        for (int i = 0; i < size - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = kb.nextInt();
        }

        System.out.println(solution(n, p));
    }
}