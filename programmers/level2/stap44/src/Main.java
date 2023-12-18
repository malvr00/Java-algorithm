import java.util.*;

public class Main {

    /**
     * Level2.
     * 기능개발
     */

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0;
            for (; progresses[i] < 100; progresses[i] += speeds[i]) {
                cnt++;
            }
            q.offer(cnt);
        }

        while (!q.isEmpty()) {
            int cnt = q.poll();
                                    int qSize = q.size();
            int pollCnt = 1;

            for (int i = 0; i < qSize; i++) {
                if (cnt < q.peek()) {
                    break;
                } else {
                    q.poll();
                    pollCnt++;
                }
            }
            arr.add(pollCnt);
        }

        answer = new int[arr.size()];

        for (int i = 0 ; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            progresses	                speeds	            return
            [93, 30, 55]	            [1, 30, 5]	        [2, 1]
            [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
         */
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        Main main = new Main();
        int[] solution = main.solution(progresses, speeds);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}