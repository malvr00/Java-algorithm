import java.util.*;

public class Main {
    /**
     * Longest Substring Without Repeating Characters
     * Window slide
     */

    public int lengthOfLongestSubstring(String s) {
        int answer = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer idx = map.get(c);
            if(idx != null && idx >= start) {
                start = idx + 1;
            }
            map.put(c, i);
            answer = Math.max(answer, i - start + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().lengthOfLongestSubstring("abba"));
    }
}