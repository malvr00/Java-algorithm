import java.util.*;

public class Main {
    /*
        2. 괄호 문자 제거
     */

    public static String solution(String str) {
        StringBuilder answer = new StringBuilder();
        char val1 = '(';
        char val2 = ')';
        Stack<Character> stack = new Stack<>();

        for (char tmp : str.toCharArray()) {
            if (val1 == tmp) {
                stack.push(tmp);
            } else if (val2 == tmp) {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    answer.append(tmp);
                }
            }

        }

        return answer.toString();
    }

    public static String solution2(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();

        System.out.println(solution(str));
    }
}