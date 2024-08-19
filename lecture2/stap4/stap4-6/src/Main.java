import java.util.*;

public class Main {

    public int solution(int[] tasks, long k) {
        int answer = 0;

        int[] sT = new int[tasks.length + 1];
        System.arraycopy(tasks, 0, sT, 1, tasks.length);
        Arrays.sort(sT);

        int rest = tasks.length;

        for (int i = 1; i < sT.length; i++) {
            long time = (((long) sT[i] - sT[i - 1]) * rest);
            if (k < time) {
                k = k % rest;
                int idx = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if (sT[i] <= tasks[j]) {
                        if(idx == k) return j + 1;
                        idx++;
                    }
                }
            } else {
                k -= time;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
        System.out.println(T.solution(new int[]{941000023, 941000023, 941000023, 23, 451200000, 136, 10025, 500999999}, 12309811L));
    }
}