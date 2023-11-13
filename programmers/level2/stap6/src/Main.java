import java.util.*;

public class Main {

    /**
     * Level2.
     * 뒤에 있는 큰 수 찾기
     */
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        stack.add(0);

        for (int i = 1; i < numbers.length; i++) {

            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }


        return answer;

    }

    public static void main(String[] args) {
        /*
              numbers                  result
            [2, 3, 3, 5]	        [3, 5, 5, -1]
            [9, 1, 5, 3, 6, 2]	    [-1, 5, 6, 6, -1, -1]
         */
        int[] arr = {9, 1, 5, 3, 6, 2};

        int[] result = solution(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}