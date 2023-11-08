import java.util.*;

public class Main {

    public static String solution(String str) {
        String result = "";
        StringBuilder val = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            boolean isChecked = false;
            if (i == 0) {
                val.append(str.charAt(i));
                continue;
            }
            for (int j = (i - 1); j >= 0; j--) {
                if (str.charAt(i) != str.charAt(j)) {
                    isChecked = true;
                } else {
                    isChecked = false;
                    break;
                }
            }
            if (isChecked) {
                val.append(str.charAt(i));
            }
        }

        result = val.toString();

        return result;
    }

    public static String solution2(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                result += str.charAt(i);
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