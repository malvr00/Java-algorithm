import java.util.*;

public class Main {

    /**
     * 강의
     * 같은 빈도수 만들기 ( 해싱, 시간파싱 )
     */
    public int[] solution(String s){
        int[] answer = new int[5];
        char[] item = {'a', 'b', 'c', 'd', 'e'};
        Map<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        for (char x : item) {
            map.put(x, 0);
        }
        for (char x : s.toCharArray()) {
            map.put(x, map.get(x) + 1);

            cnt = Math.max(cnt, map.get(x));
        }

        for (int i = 0; i < item.length; i++) {
            int val = map.get(item[i]);

            answer[i] = cnt - val;
        }

        return answer;
    }

    public int[] solution(String s, int version){
        int[] answer = new int[5];
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(sH.getOrDefault(key, 0) > max){
                max = sH.getOrDefault(key, 0);
            }
        }
        for(int i = 0; i < tmp.length(); i++){
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}