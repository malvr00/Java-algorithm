import java.util.*;

public class Main {

    /**
     * Level2.
     * 택배 배달과 수거하기 ( KAKAO )
     */
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int tmpCap = cap;
        Stack<Integer> deStack = new Stack<>();
        Stack<Integer> pickStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                deStack.add(i);
            }
            if (pickups[i] != 0) {
                pickStack.add(i);
            }
        }

        while (!deStack.isEmpty() || !pickStack.isEmpty()) {
            // 택배 출발 지점 저장
            int deIdx = 0;
            int pickIdx = 0;
            if (!deStack.isEmpty()) {
                deIdx = deStack.peek();
            }
            if (!pickStack.isEmpty()) {
                pickIdx = pickStack.peek();
            }
            answer += (Math.max(deIdx, pickIdx) + 1L) * 2;

            // 택배 배달
            while (!deStack.isEmpty() && tmpCap > 0) {
                int idx = deStack.pop();
                if (tmpCap >= deliveries[idx]) {
                    tmpCap -= deliveries[idx];
                    deliveries[idx] = 0;
                } else {
                    deStack.add(idx);
                    deliveries[idx] -= tmpCap;
                    tmpCap = 0;
                }
            }

            tmpCap = cap;

            // 수거
            while (!pickStack.isEmpty() && tmpCap > 0) {
                int idx = pickStack.pop();
                if (tmpCap >= pickups[idx]) {
                    tmpCap -= pickups[idx];
                    pickups[idx] = 0;
                } else {
                    pickStack.add(idx);
                    pickups[idx] -= tmpCap;
                    tmpCap = 0;
                }
            }

            tmpCap = cap;

        }

        return answer;
    }

    public static void main(String[] args) {

        /*
            cap	n	deliveries	            pickups	                result
            4	5	[1, 0, 3, 1, 2]	        [0, 3, 0, 4, 0]	        16
            2	7	[1, 0, 2, 0, 1, 0, 2]	[0, 2, 0, 1, 0, 2, 0]	30
         */
        int cap = 4, n = 5;
        int[] deliveries = {1, 0, 3, 1, 2}, pickups = {0, 3, 0, 4, 4};

        System.out.println(solution(cap, n, deliveries, pickups));
    }
}