import java.util.*;

public class Main {

    /**
     * Level2
     * 마법의 엘레베이터 ( 배열 )
     */


    public int solution(int storey) {
        int answer = 0;
        final int UP = 6;
        final int MIDDLE = 5;
        final int DOWN = 4;

        for (int i = 1; i <= storey; i *= 10) {
            int num = storey % (i * 10);
            int num2 = storey % (i * 100);

            while (num >= 10) {
                num /= i;
            }

            while (num2 >= 10) {
                num2 /= (i * 10);
            }

            if (num >= UP) {
                int plus = 10 - num;
                answer += plus;
                storey += i * plus;
            } else if(num <= DOWN) {
                answer += num;
            } else if (num == MIDDLE) {
                answer += num;
                if (num2 >= MIDDLE) {
                    storey += i * num;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            storey	result
            16	    6
            2554	16
            95      6
            154     10
            555     14
         */

        Main m = new Main();
        int storey = 154;
        System.out.println(m.solution(storey));
    }
}