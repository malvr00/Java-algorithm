import java.util.*;

public class Main {

    /**
     * Level3.
     * 보석 쇼핑
     * 투포인트
     */

    public int[] solution(String[] games) {
        Set<String> set = new HashSet<>(List.of(games));

        final int L = games.length;
        final int N = set.size();

        int answerStartIdx = 0, answerEndIdx = 0;
        int startIdx = 0, endIdx = 0, cnt = 0;
        int minLen = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();

        while (endIdx < L) {
            map.put(games[endIdx], map.getOrDefault(games[endIdx], 0) + 1);
            if (map.get(games[endIdx]) == 1) {
                cnt++;
            }

            endIdx++;

            while (cnt == N) {
                if (endIdx - startIdx < minLen) {
                    answerStartIdx = startIdx;
                    answerEndIdx = endIdx - 1;
                    minLen = endIdx - startIdx;
                }

                map.put(games[startIdx], map.get(games[startIdx]) - 1);
                if (map.get(games[startIdx]) == 0) {
                    cnt--;
                }
                startIdx++;
            }
        }

        return new int[]{answerStartIdx + 1, answerEndIdx + 1};
    }


    public static void main(String[] args) {
        Main m = new Main();

        String[] games = {"A", "B", "A", "A", "A", "C"};

        int[] answer = m.solution(games);

        System.out.println(Arrays.toString(answer));
    }
}