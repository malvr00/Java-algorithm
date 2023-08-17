import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String[] solution(String[] strArray) {
        String[] result = new String[strArray.length];

        for (int i = 0; i < result.length; i++) {
            String temp = "";
            for (int j = (strArray[i].length() -1); j >= 0; j--) {
                temp += strArray[i].charAt(j);
            }
            result[i] = temp;
        }
        return result;
    }

    public ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);

        int count = kb.nextInt();
        String[] strArray = new String[count];

        for (int i = 0; i < count; i++) {
            strArray[i] = kb.next();
        }

        String[] result = solution(strArray);
        for (String temp : result) {
            System.out.println(temp);
        }
    }
}