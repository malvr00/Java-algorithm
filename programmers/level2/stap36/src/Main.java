import java.util.*;

public class Main {

    /**
     * Level2.
     * 구명보트
     */
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int lt = 0, rt = people.length - 1;

        while (lt <= rt) {
            answer++;

            if (people[lt] + people[rt] <= limit) {
                lt++;
            }
            rt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            people	            limit	return
            [70, 50, 80, 50]	100	    3
            [70, 80, 50]	    100	    3
            [40, 50, 150, 160]  150     2
         */
        int[] people = {50, 50, 50, 50};
        int limit = 150;
        Main main = new Main();
        int solution = main.solution(people, limit);
        System.out.println(solution);
    }
}