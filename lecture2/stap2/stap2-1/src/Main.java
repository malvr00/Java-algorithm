import java.util.*;

public class Main {

    /**
     * 강의
     * 한 번 사용한 최초문자 ( 해싱, 시간파싱 )
     */
    public int solution(String s){
        int answer = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        boolean flag = false;
        for (Character x : map.keySet()) {
            if (map.get(x) == 1) {
                if (!flag) {
                    answer = Integer.MAX_VALUE;
                    flag = true;
                }
                answer = Math.min(answer, s.indexOf(x) + 1);
            }
        }

        return answer;
    }

    public int solution(String s, int version){
        HashMap<Character, Integer> sH = new HashMap<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(sH.get(s.charAt(i)) == 1) return i+1;
        }
        return -1;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}