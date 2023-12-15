import java.util.*;

public class Main {

    /**
     * Level2.
     * H-Index
     */
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;

        Arrays.sort(citations);

        for (int h = 0; h < citations[n - 1]; h++) {
            int low = 0;
            int high = 0;
            for (int i = 0; i < n; i++) {
                if (h > citations[i]) {
                    low++;
                } else {
                    high = n - i;
                    break;
                }
            }
            if (low <= h && high >= h) {
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        /*
            citations	        return
            [3, 0, 6, 1, 5]	    3
         */
        int[] citations = {3, 0, 6, 1, 5};
        Main main = new Main();
        int solution = main.solution(citations);
        System.out.println(solution);
    }
}