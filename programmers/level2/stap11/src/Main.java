import java.util.*;

public class Main {

    public long solution(int k, int[] tangerine) {
        long answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            answer++;
            k -= list.get(i);
            if (k <= 0) {
                break;
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        /*
            k	tangerine	                result
            6	[1, 3, 2, 5, 4, 5, 2, 3]	3
            4	[1, 3, 2, 5, 4, 5, 2, 3]	2
            2	[1, 1, 1, 1, 2, 2, 2, 3]	1
         */
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        Main main = new Main();
        System.out.println(main.solution(k, tangerine));
    }
}