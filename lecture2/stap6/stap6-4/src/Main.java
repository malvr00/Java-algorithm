import java.util.*;

public class Main {

    static int max;
    static boolean[] ch2;
    static StringBuilder builder;
    static HashSet<String> answerSet;

    public void DFS(int lv, String s) {
        if (lv == max) {
            if (Objects.equals(builder.toString(), builder.reverse().toString())) {
                answerSet.add(builder.toString());
            }
            builder.reverse();
        } else {
            for (int i = 0; i < s.length(); i++) {
                if(ch2[i]) continue;
                ch2[i] = true;
                builder.append(s.charAt(i));
                DFS(lv + 1, s);
                builder.delete(builder.length() - 1, builder.length());
                ch2[i] = false;
            }
        }
    }
    public String[] solution(String s){
        String[] answer = {};

        max = s.length();
        ch2 = new boolean[max];
        builder = new StringBuilder();
        answerSet = new HashSet<>();

        DFS(0, s);

        return answerSet.toArray(new String[0]);
    }


    /*
     * ================================================
     *                     강의
     * ================================================
     */
    Deque<Character> tmp;
    ArrayList<String> res;
    HashMap<Character, Integer> sH;
    int len;
    public void DFS(){
        if(tmp.size() == len){
            String Ts = "";
            for(char x : tmp) Ts += x;
            res.add(Ts);
        }
        else{
            for(char key : sH.keySet()){
                if(sH.get(key) == 0) continue;
                tmp.addFirst(key);
                tmp.addLast(key);
                sH.put(key, sH.get(key) - 2);
                DFS();
                tmp.pollFirst();
                tmp.pollLast();
                sH.put(key, sH.get(key) + 2);
            }
        }
    }

    public String[] solution(String s, int version){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        sH = new HashMap<>();
        len = s.length();
        for(char x : s.toCharArray()){
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }
        int odd = 0;
        char mid = '#';
        for(char key : sH.keySet()){
            if(sH.get(key) % 2 == 1){
                mid = key;
                odd++;
            }
        }
        if(odd > 1) return new String[]{};
        if(mid != '#'){
            tmp.add(mid);
            sH.put(mid, sH.get(mid) - 1);
        }
        DFS();
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution("aaaabb", 2)));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}