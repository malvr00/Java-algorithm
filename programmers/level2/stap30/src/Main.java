import java.util.*;

public class Main {

    /**
     * Level2.
     * 수식 최대화 ( KAKAO )
     */
    static List<String> arr = new ArrayList<>();
    static long answer = 0;

    static final char[] SYMPTOM = {'*', '+', '-'};
    static boolean[] ch = new boolean[3];

    public List<String> deepCopy(List<String> copy) {
        List<String> result = new ArrayList<>(copy);
        return result;
    }

    public void calculator(int startIdx, int endIdx, int syIdx) {
        long num = 0;
        switch (SYMPTOM[syIdx]) {
            case '*':
                num = Long.parseLong(arr.get(startIdx)) * Long.parseLong(arr.get(endIdx));
                break;
            case '+':
                num = Long.parseLong(arr.get(startIdx)) + Long.parseLong(arr.get(endIdx));
                break;
            case '-':
                num = Long.parseLong(arr.get(startIdx)) - Long.parseLong(arr.get(endIdx));
                break;
        }
        arr.set(startIdx, String.valueOf(num));
        arr.remove(endIdx);
        arr.remove(endIdx - 1);
    }

    public void dfs(int lv) {
        if (lv == SYMPTOM.length){
            answer = Math.max(answer, Math.abs(Long.parseLong(arr.get(0))));
        } else {
            List<String> copy = deepCopy(arr);
            for (int i = 0; i < SYMPTOM.length; i++) {
                if(ch[i]) continue;
                ch[i] = true;
                int idx = 0;
                while (idx < arr.size()) {
                    if (arr.get(idx).length() == 1 && arr.get(idx).charAt(0) == SYMPTOM[i]) {
                        calculator(idx - 1, idx + 1, i);
                        idx--;
                    } else {
                        idx++;
                    }
                }
                dfs(lv + 1);
                arr = deepCopy(copy);
                ch[i] = false;
            }
        }
    }

    public long solution(String expression) {
        StringBuilder str = new StringBuilder();
        for (char x : expression.toCharArray()) {
            if (x == SYMPTOM[0] || x == SYMPTOM[1] || x == SYMPTOM[2]) {
                arr.add(str.toString());
                arr.add(String.valueOf(x));
                str.setLength(0);
            } else {
                str.append(x);
            }
        }
        if (str.length() > 0) {
            arr.add(str.toString());
        }

        dfs(0);

        return answer;
    }

    public static void main(String[] args) {
        /*
            expression	                    result
            "100-200*300-500+20"	        60420
            "50*6-3*2"	                    300
            "200-300-500-600*40+500+500"    1248000
         */
        String expression = "200-300-500-600*40+500+500";
        Main main = new Main();
        System.out.println(main.solution(expression));
    }
}