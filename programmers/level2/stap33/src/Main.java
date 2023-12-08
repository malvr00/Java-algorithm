import java.util.*;

public class Main {

    /**
     * Level2.
     * 문자열 압축 (KAKAO)
     */
    public int gzip(String s, int type) {
        StringBuilder buf = new StringBuilder();
        StringBuilder strZip = new StringBuilder();
        StringBuilder str = new StringBuilder();

        int i = 0;
        int cnt = 1;

        for (; i < type; i++) {
            buf.append(s.charAt(i));
        }

        for (; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (buf.length() == str.length()) {
                if (buf.toString().equals(str.toString())) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        strZip.append(buf);
                    } else {
                        strZip.append(cnt).append(buf);
                    }
                    buf.setLength(0);
                    buf.append(str);
                    cnt = 1;
                }
                str.setLength(0);
            }
        }

        if (cnt == 1) {
            strZip.append(buf);
        } else {
            strZip.append(cnt).append(buf);
        }

        if (str.length() > 0) {
            strZip.append(str);
        }

        return strZip.length();
    }

    public int solution(String s) {
        int answer = 1001;
        int len = s.length() == 1 ? 1 : s.length() / 2;
        for (int i = 1; i <= len; i++) {
            answer = Math.min(answer, gzip(s, i));
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            s	                        result
            "aabbaccc"	                7
            "ababcdcdababcdcd"	        9
            "abcabcdede"	            8
            "abcabcabcabcdededededede"	14
            "xababcdcdababcdcd"	        17
         */
        String s = "a";
        Main main = new Main();
        int solution = main.solution(s);
        System.out.println(solution);
    }
}