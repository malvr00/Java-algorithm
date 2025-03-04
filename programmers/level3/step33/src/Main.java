import java.util.*;

public class Main {

    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Long> pQ = new PriorityQueue<>();

        for(String operation : operations) {
            String command = operation.split(" ")[0];
            long val = Long.parseLong(operation.split(" ")[1]);

            if ("I".equals(command)) {
                pQ.offer(val);
            } else {
                if(pQ.isEmpty()) continue;

                if (val < 0) {
                    pQ.poll();
                } else {
                    Long max = pQ.stream().max(Long::compareTo).orElseThrow();
                    pQ.remove(max);
                }
            }
        }

        if (pQ.isEmpty()) {
            answer = new int[]{0, 0};
        } else {
            long min = pQ.poll();
            long max = pQ.stream().max(Long::compareTo).orElseThrow();
            answer = new int[]{(int) max, (int) min};
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}