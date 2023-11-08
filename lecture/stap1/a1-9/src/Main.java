import java.util.*;

public class Main {
    /*
        9. 숫자만 추출
     */
    public static int solution(String str) {
        int result = 0;

        str = str.replaceAll("[^0-9]", "");
        result = Integer.parseInt(str);

        return result;
    }

    public static int solution2(String str) {
        int result = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {   // <- == Character.isDigit()
                result = result * 10 + (x - 48);
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