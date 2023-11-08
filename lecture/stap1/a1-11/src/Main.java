import java.util.*;

public class Main {
    /*
        11. 문자열 압축
     */
    public static String solution(String str) {
        String result = "";
        StringBuilder builder = new StringBuilder();
        StringBuilder tempBuilder = new StringBuilder(str);

        int count = 1;
        char strStart = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (strStart == str.charAt(i)) {
                count++;
                if (i == str.length() - 1) {
                    builder.append(strStart);
                    if (count > 1) {
                        builder.append(count);
                    }
                }
            } else {
                builder.append(strStart);
                if (count > 1) {
                    builder.append(count);
                }

                strStart = str.charAt(i);
                count = 1;
            }
        }

        result = builder.toString();

        return result;
    }

    public static String solution2(String str) {
        // 마지막 데이터에서 문제 생김.
        String result = "";
        str += "";
        int cnt = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                result += str.charAt(i);
                if (cnt > 1) {
                    result += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strValue1 = kb.next();

        System.out.println(solution(strValue1));
    }
}