import java.util.*;

public class Main {

    /**
     * Level2
     * 괄호 회전하기
     */

    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                ch = move(ch);
            }
            if (checked(ch)) {
                answer++;
            }
        }

        return answer;
    }

    public char[] move(char[] chars) {
        char tmp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = tmp;

        return chars;
    }

    public boolean checked(char[] ch) {
        Stack<Character> stack = new Stack<>();
        final char B_1 = '[';
        final char B_2 = ']';
        final char B_3 = '(';
        final char B_4 = ')';
        final char B_5 = '{';
        final char B_6 = '}';

        for (char s : ch) {
            switch (s) {
                case B_1:
                case B_3:
                case B_5:
                    stack.push(s);
                    break;
                case B_2:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop1 = stack.pop();
                    if (pop1 != B_1) {
                        return false;
                    }
                    break;
                case B_4:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop2 = stack.pop();
                    if (pop2 != B_3) {
                        return false;
                    }
                    break;
                case B_6:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character pop3 = stack.pop();
                    if (pop3 != B_5) {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        /*
            s	        result
            "[](){}"	3
            "}]()[{"	2
            "[)(]"	    0
            "}}}"	    0
         */
        String s = "{";
        Main main = new Main();
        int solution = main.solution(s);
        System.out.println(solution);
    }
}