import java.util.*;

public class Main {

    /**
     * 강의.
     * 서로 다른 빈도수 만들기 ( 해쉬, 시간파싱 )
     */
    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char key1 : map.keySet()) {
            boolean flag = true;
            while (flag) {
                for (char key2 : map.keySet()) {
                    if(key1 == key2 || map.get(key1) == 0) continue;
                    int key1Val = map.get(key1);
                    int key2Val = map.get(key2);

                    if (key1Val == key2Val) {
                        answer++;
                        flag = true;
                        map.put(key1, map.get(key1) - 1);
                        if (map.get(key1) == 0) {
                            flag = false;
                        }
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
        }

        return answer;
    }

    public int solution(String s, int version){
        int answer = 0;
        HashMap<Character, Integer> sH = new HashMap<>();
        HashSet<Integer> ch = new HashSet<>();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        for(char key : sH.keySet()){
            while(ch.contains(sH.get(key))){
                answer++;
                sH.put(key, sH.get(key) - 1);
            }
            if(sH.get(key) == 0) continue;
            ch.add(sH.get(key));
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc", 2));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}