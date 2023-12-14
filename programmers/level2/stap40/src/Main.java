import java.util.*;

public class Main {

    /**
     * Level2.
     * 소수 찾기
     */
    static boolean[] ch;
    static int answer = 0;
    static HashSet<Integer> set = new HashSet<>();

    public void dfs(String numbers, String str) {
        if (str.length() == numbers.length()) {
            return;
        } else {
            for (int i = 0; i < numbers.length(); i++) {
                int val = Integer.parseInt(str + numbers.charAt(i));
                if (!ch[i]) {
                    ch[i] = true;
                    if (checked(val)) {
                        answer++;
                    }
                    dfs(numbers, str + numbers.charAt(i));
                    ch[i] = false;
                }
            }
        }
    }

    public boolean checked(int val) {
        if (val == 1 || val == 0 || set.contains(val)) return false;
        set.add(val);

        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(String numbers) {
        ch = new boolean[numbers.length()];

        dfs(numbers, "");

        return answer;
    }

    public static void main(String[] args) {
        /*
            numbers	return
            "17"	3
            "011"	2
         */
        String numbers = "011";
        Main main = new Main();
        int solution = main.solution(numbers);
        System.out.println(solution);
    }
}