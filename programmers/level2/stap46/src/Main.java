import java.util.*;

public class Main {

    /**
     * Level2.
     * 짝지어 제거하기
     */
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {
            boolean flag = false;
            if (!stack.isEmpty()) {
                if (stack.peek() == x) {
                    stack.pop();
                    flag = true;
                }
            }
            if (!flag) {
                stack.add(x);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        /*
            s       result
            "baab"  1
            "cdcd"  0
         */
        String s = "baabc";
        Main main = new Main();
        int solution = main.solution(s);
        System.out.println(solution);
    }
}