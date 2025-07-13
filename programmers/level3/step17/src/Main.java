import java.util.*;

public class Main {

    /**
     * Level3.
     * 가장 긴 팰린드롬
     */
    
    private static int len;

    public int pal(String s, int left, int right) {
        // 양 끝이 같다면 그 문자열은 팰린드롬으로 판단
        // -> 문자열의 중심부터 좌우로 퍼지면서 탐색하기 때문에 양 끝만 비교해도 팰린드롬 문자열을 찾을 수 있다.
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public int solution(String s)
    {
        int answer = 0;

        len = s.length();

        for (int i = 0; i < len; i++) {
            answer = Math.max(pal(s, i, i), answer);
            answer = Math.max(pal(s, i, i + 1), answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        String s = "abcdcba";

        System.out.println(m.solution(s));
    }
}