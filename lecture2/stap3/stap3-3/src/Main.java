import java.util.*;

public class Main {

    /**
     * 강의.
     * 현관문 출입순서 ( 자료구조 활용 )
     */
    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();

        int idx = 0;
        int prev = 1;
        int time = arrival[0];
        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            if (time < arrival[i]) {
                time = arrival[i];
                prev = 1;
            }
            while (idx < arrival.length && time >= arrival[idx]) {
                if (state[idx] == 0) {
                    enterQ.offer(idx);
                } else {
                    exitQ.offer(idx);
                }
                idx++;
            }

            if (!enterQ.isEmpty() && exitQ.isEmpty()) {
                prev = 0;
            } else if (!exitQ.isEmpty() && enterQ.isEmpty()) {
                prev = 1;
            }

            if (prev == 0) {
                if (!enterQ.isEmpty()) {
                    answer[enterQ.poll()] = time;
                }
            } else {
                if (!exitQ.isEmpty()) {
                    answer[exitQ.poll()] = time;
                }
            }

            time++;
        }

        return answer;
    }

    public int[] solution(int[] arrival, int[] state, int version){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length, prev = 1;
        int[] answer = new int[n];
        for(int t = 0, i = 0, cnt = 0; ; t++){
            if(enter.isEmpty() && exit.isEmpty() && i < n) {
                if(t < arrival[i]){
                    t = arrival[i];
                    prev = 1;
                }
            }
            while(i < n && arrival[i] <= t) {
                if (state[i] == 0) enter.offer(i);
                else exit.offer(i);
                i++;
            }
            if(prev == 1) {
                if(!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
                else{
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            }else if(prev == 0) {
                if(!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                }else{
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if(cnt == n) break;
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new int[]{0},
                new int[]{0})));
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8},
                new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5},
                new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10},
                new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}