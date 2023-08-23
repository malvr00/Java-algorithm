import java.util.*;

public class Main {
    /*
        6. 뒤집은 소수
     */

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List<Integer> solution2(int n, String str) {
        List<Integer> result = new ArrayList<>();
        String[] val = str.split("\\s");

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(val[i]);
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res)) {
                result.add(res);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strVal1 = kb.nextLine();
        String strVal2 = kb.nextLine();
        int nVal1 = Integer.parseInt(strVal1);

        solution2(nVal1, strVal2).forEach(obj -> System.out.print(obj + " "));
//        System.out.println();
    }
}