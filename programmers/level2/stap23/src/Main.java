import java.util.*;

public class Main {

    /**
     * Level2.
     * 모음사전
     */
    static boolean flag = false;
    static int cnt = 0;
    static final String[] alp = {"A", "E", "I", "O", "U"};

    public void DFS(String word, StringBuilder str) {
        if(flag) return;
        if (str.toString().equals(word)) {
            flag = true;
        } else {
            for (int i = 0; i < alp.length; i++) {
                if (str.length() >= 0 && str.length() < 5 && !flag) {
                    cnt++;
                    str.append(alp[i]);
                    DFS(word, str);
                    str.deleteCharAt(str.lastIndexOf(alp[i]));
                } else {
                    break;
                }
            }
        }
    }

    public int solution(String word) {

        DFS(word, new StringBuilder());

        return cnt;
    }

    public static void main(String[] args) {
        /*
            word	result
            "AAAAE"	6
            "AAAE"	10
            "I"	    1563
            "EIO"	1189
         */
        String word = "EIO";
        Main main = new Main();
        System.out.println(main.solution(word));
    }
}