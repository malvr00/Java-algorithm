import java.util.*;

public class Main {

    /**
     * Level2.
     * 두 큐 합 같게 만들기 ( KAKAO )
     */
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long sumQ1 = 0;
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i];
            arr.add(queue1[i]);
        }
        sumQ1 = sum;
        for (int i = 0; i < queue1.length; i++) {
            sum += queue2[i];
            arr.add(queue2[i]);
        }

        int ltQ1 = 0, rtQ1 = queue1.length - 1;

        while (sumQ1 != sum / 2) {
            while (sumQ1 >= sum / 2) {
                if (sumQ1 == sum / 2) {
                    return answer;
                }
                answer++;
                sumQ1 -= arr.get(ltQ1);
                ltQ1++;
                if (ltQ1 == arr.size() - 1) {
                    return -1;
                }
            }
            while (sumQ1 <= sum / 2) {
                if (sumQ1 == sum / 2) {
                    return answer;
                }
                answer++;
                rtQ1 = rtQ1 == arr.size() - 1 ? 0 : rtQ1 + 1;
                sumQ1 += arr.get(rtQ1);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /*
            queue1	        queue2	        result
            [3, 2, 7, 2]	[4, 6, 5, 1]	2
            [1, 2, 1, 2]	[1, 10, 1, 2]	7
            [1, 1]	        [1, 5]	        -1
         */
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, };
        Main main = new Main();
        int solution = main.solution(queue1, queue2);
        System.out.println(solution);
    }
}