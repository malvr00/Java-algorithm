import java.util.*;

public class Main {
    /*
        2. 가위바위보
     */
    public static List<String> solution(int target, String str1, String str2) {
        List<String> result = new ArrayList<>();

        String[] userA = str1.split("\\s");
        String[] userB = str2.split("\\s");

        for (int i = 0; i < target; i++) {
            int val1 = Integer.parseInt(userA[i]);
            int val2 = Integer.parseInt(userB[i]);

            if (val1 == 1 && val2 == 2) {
                result.add("B");
            } else if (val1 == 2 && val2 == 3) {
                result.add("B");
            } else if (val1 == 3 && val2 == 1) {
                result.add("B");
            } else if (val1 == val2) {
                result.add("D");
            } else {
                result.add("A");
            }
        }


        return result;
    }

    public static String solution2(int n, String str1, String str2) {
        String result = "";
        String[] userA = str1.split("\\s");
        String[] userB = str2.split("\\s");

        for (int i = 0; i < n; i++) {
            int val1 = Integer.parseInt(userA[i]);
            int val2 = Integer.parseInt(userB[i]);

            if (val1 == val2) {
                result += "D";
            } else if (val1 == 1 && val2 == 3) {
                result += "A";
            } else if (val1 == 2 && val2 == 1) {
                result += "A";
            } else if (val1 == 3 && val2 == 2) {
                result += "A";
            } else {
                result += "B";
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String strVal1 = kb.nextLine();
        String strVal2 = kb.nextLine();
        String strVal3 = kb.nextLine();
        int nVal1 = Integer.parseInt(strVal1);
        solution(nVal1, strVal2, strVal3).forEach(obj -> System.out.println(obj));
//        System.out.println();
    }
}