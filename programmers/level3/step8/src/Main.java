import java.util.*;

public class Main {

    /**
     * Level3
     * [KAKAO BLIND RECRUITMENT] 표현 가능한 이진트리
     */

    int result;
    public void tree(int s, int e, boolean isRootZero, boolean[] ch) {
        // 1 0 1
        if(result == 0) return;
        int mid = (s + e) / 2;

        if (isRootZero && ch[mid]) {
            result = 0;
            return;
        }

        if (s < e) {
            tree(s, mid - 1, !ch[mid], ch);
            tree(mid + 1, e, !ch[mid], ch);
        }
    }

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int answerIdx = 0;

        for (long number : numbers) {
            // 2 진수 변환
            String binary = Long.toBinaryString(number);

            // 이진트리 노드 개수
            int pow = 1;
            int nodeCnt = 1;
            while (nodeCnt < binary.length()) {
                nodeCnt += (int) Math.pow(2, pow++);
            }

            boolean[] ch = new boolean[nodeCnt];
            int chIdx = nodeCnt - binary.length();

            // 더미노드 생성
            for (int i = 0; i < binary.length(); i++) {
                ch[chIdx++] = binary.charAt(i) == '1';
            }

            result = 1;
            tree(0, ch.length - 1, false, ch);
            answer[answerIdx++] = result;
        }

        return answer;
    }
    public static void main(String[] args) {
        Main T = new Main();
        long[] numbers = {7, 42, 5};
        System.out.println(Arrays.toString(T.solution(numbers)));
    }
}