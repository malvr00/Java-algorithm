import java.util.*;

public class Main {

    /**
     * Level2.
     * 괄호 변환 ( KAKAO )
     */
    public boolean checked(String u) {
        Stack<Character> stack = new Stack<>();

        for (char x : u.toCharArray()) {
            if (x == '(') {
                stack.add(x);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public String changeBlock(String v) {
        StringBuilder answer = new StringBuilder();
        for (char x : v.toCharArray()) {
            if (x == '(') {
                answer.append(')');
            } else {
                answer.append('(');
            }
        }

        return answer.toString();
    }

    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(p.length() == 0 || checked(p)) return p;

        boolean flag = false;
        boolean ch = false;
        int l = 0;
        int r = 0;
        for (char x : p.toCharArray()) {
            if (!flag) {
                u.append(x);
                if (x == '(') {
                    l++;
                } else if (x == ')') {
                    r++;
                }
                if (r > 0 && l == r) {
                    flag = true;
                    ch = checked(u.toString());
                    if (ch) {
                        answer.append(u);
                        u.setLength(0);
                    }
                }
            } else {
                v.append(x);
            }
        }
        if (ch) {
            return answer.append(solution(v.toString())).toString();
        } else {
            String strV = v.length() == 0 ? "" : solution(v.toString());
            int len = u.length() == 2 ? 1 : 2;
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    answer.append('(').append(strV).append(')');
                } else {
                    u.delete(0, 1);
                    u.delete(u.length() - 1, u.length());
                    answer.append(changeBlock(u.toString()));
                }
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        /*
            p	                    result
            "(()())()"	            "(()())()"
            ")("	                "()"
            "()))((()"	            "()(())()"
            ")))((("                "()(())"
         */
        String p = ")))(((";
        Main main = new Main();
        String solution = main.solution(p);
        System.out.println(solution);
    }
}