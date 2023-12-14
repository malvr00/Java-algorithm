import java.util.*;

public class Main {

    /**
     * Level2.
     * 조이스틱
     */
    public int solution(String name) {
        /*
            65 ~ 90
         */
        int answer = 0;
        int move = name.length() - 1;

        int idx = 0;
        for (char x : name.toCharArray()) {
            int upDown = Math.min(x - 65, 91 - x);
            answer += upDown;

            int nextIdx = idx + 1;
            while (nextIdx < name.length() && name.charAt(nextIdx) == 65) {
                nextIdx++;
            }

            // 1. idx * 2 하는 이유는 현재 위치에서 뒤로 돌아가는 것 만큼 숫자를 더해야 하기 때문이다.
            // 2. name.length() - nextIdx 는 idx * 2 로 처음위치까지 이동 값을 구했으면
            // 커서를 뒤로 이동해 마지막 'A' 인덱스까지 이동하기 위해
            move = Math.min(move, idx * 2 + name.length() - nextIdx);
            move = Math.min(move, (name.length() - nextIdx) * 2 + idx);
            idx++;
        }

        return answer + move;
    }

    public static void main(String[] args) {
        /*
            name	    return
            "JEROEN"	56
            "JAN"	    23
         */
        String name = "BBAABB";
        Main main = new Main();
        int solution = main.solution(name);
        System.out.println(solution);
    }
}