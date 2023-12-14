import java.util.*;

public class Main {

    /**
     * Level2.
     * 카펫
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int i = 3; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                int num = sum / i;
                if ((i - 2) * (num - 2) == yellow) {
                    answer[0] = num;
                    answer[1] = i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            brown	yellow	return
            10	    2   	[4, 3]
            8	    1   	[3, 3]
            24	    24  	[8, 6]
         */
        int brown = 3004;
        int yellow = 2996;
        Main main = new Main();
        int[] solution = main.solution(brown, yellow);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}