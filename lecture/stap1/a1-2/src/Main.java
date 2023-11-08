import java.util.Scanner;

public class Main {

    public static String solution(String str) {
        String result = "";

        for (char temp : str.toCharArray()) {
            if (Character.isLowerCase(temp)) {
                result += Character.toUpperCase(temp);
            } else {
                result += Character.toLowerCase(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strInput = kb.nextLine();

        System.out.println(solution(strInput));
    }
}