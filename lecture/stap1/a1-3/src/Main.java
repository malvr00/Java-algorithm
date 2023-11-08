import java.util.Scanner;

public class Main {

    public static String solution(String str) {
        String result = "";

        String[] val = str.split(" ");
        for (int i = 0; i < val.length; i++) {
            String temp = val[i];

            if (result.length() < temp.length()) {
                result = temp;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);

        String strValue = kb.nextLine();
        System.out.println(solution(strValue));
    }
}