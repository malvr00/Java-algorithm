import java.util.*;

public class Main {

    static List<String> answerList;
    static String[] memo;
    static int MAX_LV = 4;
    static int MIN_IP = 0;
    static int MAX_IP = 255;

    public void DFS(int lv, int i, String s) {
        if (MAX_LV == lv) {
            if(i != s.length()) return;
            StringBuilder builder = new StringBuilder();
            for (int z = 0; z < memo.length; z++) {
                builder.append(memo[z]);
                if (z == 0 || z % (memo.length - 1) != 0) {
                    builder.append(".");
                }
            }
            answerList.add(builder.toString());
            memo[lv - 1] = "";
        } else {
            for (; i < s.length(); i++) {
                StringBuilder builder = new StringBuilder(memo[lv]);
                builder.append(s.charAt(i));

                if (builder.length() > 1) {
                    char c = builder.charAt(0);
                    if (Character.getNumericValue(c) == MIN_IP) {
                        memo[lv] = "";
                        break;
                    }
                }
                if (Integer.parseInt(builder.toString()) > MAX_IP) {
                    memo[lv] = "";
                    break;
                }
                memo[lv] = builder.toString();
                DFS(lv + 1, i + 1, s);
            }
        }
    }
    public String[] solution(String s){
        answerList = new ArrayList<>();
        memo = new String[]{"", "", "", ""};

        DFS(0, 0, s);

        return answerList.toArray(new String[0]);
    }

    /*
     *  ==========================
     *            강의
     *  ===========================
     */
    LinkedList<String> tmp;
    ArrayList<String> res;
    public void DFS(int start, String s){
        if(tmp.size() == 4 && start == s.length()){
            String Ts = "";
            for(String x : tmp) Ts += x + ".";
            res.add(Ts.substring(0, Ts.length()-1));
        }
        else{
            for(int i = start; i < s.length(); i++){
                if(s.charAt(start) == '0' && i > start) return;
                String num = s.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) return;
                tmp.add(num);
                DFS(i + 1, s);
                tmp.pollLast();
            }
        }
    }

    public String[] solution(String s, int version){
        tmp = new LinkedList<>();
        res = new ArrayList<>();
        DFS(0, s);
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}