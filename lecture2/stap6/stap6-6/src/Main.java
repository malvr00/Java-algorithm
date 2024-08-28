import java.util.*;

public class Main {

    static int MAX_LV;
    static LinkedList<String> list;
    static int cnt;

    public void DFS(int lv, int start, String s) {
        if (start == MAX_LV) {
            cnt++;
        } else {
            for (int i = start; i < s.length(); i++) {
                String substring = s.substring(start, i + 1);
                if (substring.charAt(0) == '0') {
                    break;
                }
                if (Integer.parseInt(substring) > 26) {
                    break;
                }
                list.add(substring);
                DFS(lv + 1, i + 1, s);
                list.pollLast();
            }
        }
    }

    public int solution(String s){
        int answer = 0;

        cnt = 0;
        MAX_LV = s.length();
        list = new LinkedList<>();

        DFS(0, 0, s);

        answer = cnt;

        return answer;
    }

    /*
     * ======================
     *         강의
     * ======================
     */

    int[] dy;
    public int DFS(int start, String s){
        if(dy[start] > 0) return dy[start];
        if(start < s.length() && s.charAt(start) == '0') return 0;
        if(start == s.length() -1 || start == s.length()) return 1;
        else{
            int res = DFS(start + 1, s);
            int tmp = Integer.parseInt(s.substring(start, start + 2));
            if(tmp <= 26) res += DFS(start + 2, s);
            return dy[start] = res;
        }
    }
    public int solution(String s, int version){
        dy = new int[101];
        int answer = DFS(0, s);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}