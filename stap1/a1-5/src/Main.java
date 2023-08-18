import java.util.Scanner;

public class Main {

    public static String solution(String str) {
        String result = "";

        int left = 0;
        int right = str.length() - 1;

        char[] val = str.toCharArray();
        while (left < right) {
            char leftVal = val[left];
            char rightVal = val[right];
            if ((leftVal >= 'a' && leftVal <= 'z') || (leftVal >= 'A' && leftVal <= 'Z')) {
                if ((rightVal >= 'a' && rightVal <= 'z') || (rightVal >= 'A' && rightVal <= 'Z')) {
                    val[left] = val[right];
                    val[right] = leftVal;
                    left++;
                }
                right--;
            } else {
                left++;
            }
        }
        result = String.valueOf(val);

        return result;
    }

    public static String solution2(String str) {
        String result = "";

        int left = 0;
        int right = str.length() - 1;

        char[] val = str.toCharArray();

        while (left < right) {
            if (!Character.isAlphabetic(val[left])) {
                left++;
            } else if (!Character.isAlphabetic(val[right])) {
                right--;
            } else {
                char tmp = val[left];
                val[left] = val[right];
                val[right] = tmp;
                left++;
                right--;
            }
        }

        result = String.valueOf(val);

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strValue = kb.nextLine();

        System.out.println(solution(strValue));
    }
}