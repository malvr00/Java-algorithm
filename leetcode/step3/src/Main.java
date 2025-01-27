import java.util.*;

public class Main {

    /**
     * Valid Parentheses
     */

    public boolean isValid(String s) {
        if(s.length() == 1) return false;

        final char MODE_1_1 = '(';
        final char MODE_1_2 = ')';
        final char MODE_2_1 = '[';
        final char MODE_2_2 = ']';
        final char MODE_3_1 = '{';
        final char MODE_3_2 = '}';
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == MODE_1_1) {
                stack.add(s.charAt(i));
            } else if(s.charAt(i) == MODE_1_2) {
                if(stack.isEmpty()) return false;
                if(!(MODE_1_1 == stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if(s.charAt(i) == MODE_2_1) {
                stack.add(s.charAt(i));
            } else if(s.charAt(i) == MODE_2_2) {
                if(stack.isEmpty()) return false;
                if(!(MODE_2_1 == stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if(s.charAt(i) == MODE_3_1) {
                stack.add(s.charAt(i));
            } else if(s.charAt(i) == MODE_3_2) {
                if(stack.isEmpty()) return false;
                if(!(MODE_3_1 == stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return !(stack.size() > 0);
    }

    public static void main(String[] args) {
        System.out.println(new Main().isValid(")("));
    }
}