import java.util.*;

public class Main {
    /*
        5. 소수 (에라토스테네스 체)
     */
    public static int solution(int target) {
        // 1초 초과
        List<Integer> values = new ArrayList<>();

        for (int i = 2; i <= target; i++) {
            values.add(i);
        }

        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(j) % values.get(i) == 0) {
                    values.remove(j);
                }
            }
        }

        return values.size();
    }

    public static int solution2(int n) {
        int result = 0;
        int[] value = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (value[i] == 0) {
                result++;
                for (int j = i; j <= n; j = j + i) {
                    value[j] = 1;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int nVal1 = kb.nextInt();

        System.out.println(solution2(nVal1));
    }
}