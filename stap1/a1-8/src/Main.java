import java.util.*;

public class Main {
    /*
        8. 유효한 팰린드롬
     */
    public static String solution(String str) {
        String result = "";
        final String Y = "YES";
        final String N = "NO";

        str = str.replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]", "");
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


        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strValue = kb.nextLine();

        System.out.println(solution(strValue));
    }
}