import java.util.*;

public class Main {

    /**
     * 강의.
     * 회의실 강의 ( 시뮬레이션 & 구현 )
     */
    public int[] solution(int[] enter, int[] exit){
        int n = enter.length;
        for(int i = 0; i < n; i++){
            enter[i]--;
            exit[i]--;
        }

        // 몇 번째로 들어왔는지 기록
        int[] enterIdx = new int[n];    // 손님이 몇 번째로 들어왔는지 기록. key = 손님번호 value = 방문 값
        for(int i = 0; i < n; i++){
            enterIdx[enter[i]] = i;
        }

        int[] enterT = new int[n];  // 입실 한 시간
        int[] exitT = new int[n];   // 퇴신 한 시간
        int cnt = 0;                // 시간의 흐름
        for(int i = 0, j = 0; i < n; i++){
            while(j < n && j <= enterIdx[exit[i]]){
                enterT[enter[j]] = cnt++;
                j++;
            }
            exitT[exit[i]] = cnt++;
        }

        // 시간 흐름상 만나게 되면 answer에 누적
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(!(exitT[i] < enterT[j] || exitT[j] < enterT[i])){
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}