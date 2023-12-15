import java.util.*;

public class Main {

    /**
     * Level2.
     * 가장 큰 수
     */
    public String solution(int[] numbers) {
        StringBuilder str = new StringBuilder();
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String x : arr) {
            str.append(x);
        }

        return str.charAt(0) == '0' ? "0" : str.toString();
    }

    public static void main(String[] args) {
        /*
            numbers	            return
            [6, 10, 2]	        "6210"
            [3, 30, 34, 5, 9]	"9534330"
            [7, 70, 71]         "77170"
         */
        int[] numbers = {7, 70 , 71};
        Main main = new Main();
        String solution = main.solution(numbers);
        System.out.println(solution);

    }
}