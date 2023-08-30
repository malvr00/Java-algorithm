import java.util.*;

public class Main {
    /*
        4. 후위식 연산(postfix)
     */

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        Character LEFT_ICON = '(';
        Character RIGHT_ICON = ')';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == LEFT_ICON) {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if (str.charAt(i - 1) != RIGHT_ICON) {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static int solution2(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();

        System.out.println(solution(str));
    }
}