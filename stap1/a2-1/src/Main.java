import java.util.*;

public class Main {
    /*
        1. 큰 수 출력하기
     */
    public static List<Integer> solution(int target, String str) {
        List<Integer> result = new ArrayList<>();

        String[] s = str.split("\\s");
        result.add(Integer.parseInt(s[0]));

        for (int i = 1; i < target; i++) {
            int val1 = Integer.parseInt(s[i]);
            int val2 = Integer.parseInt(s[i - 1]);

            if (val1 > val2) {
                result.add(val1);
            }

        }

        return result;
    }

    public static String solution2(int n, String str) {
        String result = "";

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strVal1 = kb.nextLine();
        String strVal2 = kb.nextLine();
        int nVal1 = Integer.parseInt(strVal1);

        List<Integer> solution = solution(nVal1, strVal2);

        solution.forEach(obj -> System.out.print(obj + " "));

        System.out.println();
    }
}