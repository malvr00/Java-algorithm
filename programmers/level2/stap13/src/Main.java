import java.util.*;

public class Main {

    /**
     * Level2.
     * 택배상자
     */
    public int solution(int[] order) {
        int answer = 0;
        int lan = order.length;
        int lt = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= lan; i++) {
            if (order[lt] == i) {
                lt++;
                answer++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == order[lt]) {
                        lt++;
                        answer++;
                        stack.pop();
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        /*
            order	            result
            [4, 3, 1, 2, 5]	    2
            [5, 4, 3, 2, 1]	    5
         */
        int[] order = {5, 4, 3, 2, 1};
        Main main = new Main();
        int solution = main.solution(order);

        System.out.println(solution);
    }
}