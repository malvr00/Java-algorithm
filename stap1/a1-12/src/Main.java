import java.util.*;

public class Main {
    /*
        12. 암호
     */
    public static String solution(String str, int target) {
        String result = "";
        StringBuilder resultTemp = new StringBuilder();

        HashMap<Character, Integer> secretKey = new HashMap<>();
        secretKey.put('#', 1);
        secretKey.put('*', 0);

        for (int i = 0; i < str.length(); i++) {
            if (resultTemp.length() < 7) {
                resultTemp.append(secretKey.get(str.charAt(i)));
                if (i == str.length() - 1) {
                    int decimal = Integer.parseInt(resultTemp.toString(), 2);
                    result += (char) decimal;
                }
            } else {
                int decimal = Integer.parseInt(resultTemp.toString(), 2);
                result += (char) decimal;

                resultTemp.setLength(0);
                resultTemp.append(secretKey.get(str.charAt(i)));
            }
        }

        return result;
    }

    public static String solution2(int n, String str) {
        String result = "";

        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            result += (char) num;
            str = str.substring(7);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int nValue2 = kb.nextInt();
        String strValue1 = kb.next();

        System.out.println(solution(strValue1, nValue2));
    }
}