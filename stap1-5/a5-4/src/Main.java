import java.util.*;

public class Main {
    /*
        4. 후위식 연산(postfix)
     */

    public static int solution(String str) {
        int answer = 0;

        final Character PLUS = '+';
        final Character MINUS = '-';
        final Character TIMES = '*';
        final Character BY = '/';

        Stack<Integer> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(Integer.parseInt(String.valueOf( x )));
            } else {
                int sec = Integer.parseInt(String.valueOf( stack.pop() ));
                int top = Integer.parseInt(String.valueOf( stack.pop() ));
                int result = 0;
                if (x == PLUS) {
                    result = top + sec;
                } else if (x == MINUS) {
                    result = top - sec;
                } else if (x == TIMES) {
                    result = top * sec;
                } else if (x == BY) {
                    result = top / sec;
                }
                stack.push(result);
            }
        }
        answer = stack.pop();


        return answer;
    }

    public static int solution2(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(x - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (x == '+') {
                    stack.push(lt + rt);
                } else if (x == '-') {
                    stack.push(lt - rt);
                } else if (x == 'x') {
                    stack.push(lt * rt);
                } else if (x == '/') {
                    stack.push(lt / rt);
                }

            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();

        System.out.println(solution(str));
    }
}