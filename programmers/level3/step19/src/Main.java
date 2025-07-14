import java.util.*;

public class Main {

    /**
     * Level3
     * 야근지수
     * 힙
     */

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works) {
            pQ.offer(work);
        }

        while(!pQ.isEmpty() && n > 0) {
            n--;
            int val = pQ.poll() - 1;
            if(val > 0) {
                pQ.offer(val);
            }
        }

        while(!pQ.isEmpty()) {
            int val = pQ.poll();
            answer += Math.pow(val, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        int n = 4;
        int[] works = {4, 3, 3};

        System.out.println(m.solution(n, works););
    }
}