import java.util.*;

public class Main {
    /*
        1. 올바른 괄호
     */

    public static String solution(String str) {
        String answer = "YES";
        char val1 = '(';
        Stack<Character> stack = new Stack<>();

        for (char tmp : str.toCharArray()) {
            if (tmp == val1) {
                stack.push(val1);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = "NO";
        }



        return answer;
    }

    public static int solution2(String str) {
        int answer = -1;

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();

        System.out.println(solution(str));
    }
}