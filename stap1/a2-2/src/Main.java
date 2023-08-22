import java.util.*;

public class Main {
    /*
        2. 보이는 학생
     */
    public static int solution(int target, String str) {
        String[] split = str.split("\\s");
        int count = 1;

        for (int i = 1; i < target; i++) {
            boolean flag = false;
            int val1 = Integer.parseInt(split[i]);
            for (int j = i - 1; j >= 0; j--) {
                int val2 = Integer.parseInt(split[j]);
                if (val1 > val2) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static int solution2(int n, String str) {
        String[] split = str.split("\\s");
        int result = 1, max = Integer.parseInt(split[0]);

        for (int i = 1; i < n; i++) {
            if (Integer.parseInt(split[i]) > max) {
                result++;
                max = Integer.parseInt(split[i]);
            }
        }

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