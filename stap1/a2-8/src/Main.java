import java.util.*;

public class Main {
    /*
        8. 등수 구하기
     */

    public static List<Integer> solution(int n, String str) {
        List<Integer> result = new ArrayList<>();
        String[] val = str.split(" ");

        for (int i = 0; i < n; i++) {
            int rank = n;
            int tmp = Integer.parseInt(val[i]);

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int tmp2 = Integer.parseInt(val[j]);

                if (tmp >= tmp2) {
                    rank--;
                }
            }

            result.add(rank);

        }

        return result;
    }

    public static List<Integer> solution2(int n, String str) {
        List<Integer> result = new ArrayList<>();
        String[] val = str.split(" ");

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(val[i]);
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                int tmp2 = Integer.parseInt(val[j]);
                if (tmp2 > tmp) {
                    cnt++;
                }
            }
            result.add(cnt);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strVal1 = kb.nextLine();
        String strVal2 = kb.nextLine();
        int nVal1 = Integer.parseInt(strVal1);
        solution(nVal1, strVal2).forEach(obj -> System.out.print(obj + " "));
        System.out.println();
    }
}