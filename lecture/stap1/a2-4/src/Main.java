import java.util.*;

public class Main {
    /*
        4. 피보나치 수열
     */
    public static List<Integer> solution(int target) {
        List<Integer> result = new ArrayList<>();

        int first = 0;
        int sec = 1;
        int answer = 0;

        for (int i = 0; i < target; i++) {
            answer = first + sec;
            result.add(sec);
            first = sec;
            sec = answer;
        }
        return result;
    }

    public static int[] solution2(int n) {
        int[] result = new int[n];

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int nVal1 = kb.nextInt();
        solution(nVal1).forEach(obj -> System.out.print(obj + " "));
    }
}