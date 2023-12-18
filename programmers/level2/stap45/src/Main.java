import java.util.*;

public class Main {

    /**
     * Level2.
     * 더 맵게
     */
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for (int x : scoville) {
            pQ.offer(x);
        }

        while (!pQ.isEmpty()) {
            int poll = pQ.poll();
            if (poll < K) {
                if (pQ.isEmpty()) {
                    return -1;
                }
                answer++;
                int num = poll + pQ.poll() * 2;
                pQ.offer(num);
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            scoville	            K	return
            [1, 2, 3, 9, 10, 12]	7	2
         */
        int[] scoville = {12, 1};
        int k = 12;
        Main main = new Main();
        int solution = main.solution(scoville, k);
        System.out.println(solution);
    }

}