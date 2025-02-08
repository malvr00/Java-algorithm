import java.util.*;

public class Main {

    /**
     * Longest Repeating Character Replacement
     * Sliding window / Two Point
     */
    public int characterReplacement(String s, int k) {
        int answer = 0;

        int start = 0, maxCnt = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int cnt = map.get(c);
            maxCnt = Math.max(maxCnt, cnt);

            while((i - start + 1) - maxCnt > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }

            answer = Math.max(answer, i - start + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().characterReplacement("AABAABBBBB", 1));
    }
}