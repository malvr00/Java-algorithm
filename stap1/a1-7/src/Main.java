import java.util.*;

public class Main {

    public static String solution(String str) {
        String result = "";
        final String Y = "YES";
        final String N = "NO";

        StringBuilder strVal = new StringBuilder(str).reverse();

        if (strVal.toString().equalsIgnoreCase(str)) {
            result = Y;
        } else {
            result = N;
        }

        return result;
    }

    public static String solution2(String str) {
        String result = "YES";

        str = str.toUpperCase();
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                result = "NO";
                break;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strValue = kb.nextLine();

        System.out.println(solution(strValue));
    }
}