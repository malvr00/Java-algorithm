import java.util.*;

public class Main {
    /*
        7. 점수계산
     */

    public static int solution(int n, String str) {
        int result = 0;
        String[] val = str.split(" ");

        int num = 0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(val[i]);

            if (tmp > 0) {
                num++;
                result += num;
            } else {
                num = 0;
            }
        }
        return result;
    }

    public static List<Integer> solution2(int n, String str) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strVal1 = kb.nextLine();
        String strVal2 = kb.nextLine();
        int nVal1 = Integer.parseInt(strVal1);

        System.out.println(solution(nVal1, strVal2));
    }
}