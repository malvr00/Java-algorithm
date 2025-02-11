import java.util.*;

public class Main {

    /**
     * LEVE3
     * [현대 모비스] 상당원 인원
     * PriorityQueue, Combination(backtracking)
     */

    int answer = Integer.MAX_VALUE;
    // 상담 유형 별 상담사 배치
    List<Integer> room = new ArrayList<>();

    // 상담 시작
    public void select(int[][] reqs) {
        int timeCnt = 0;

        PriorityQueue<Integer>[] pq = new PriorityQueue[room.size()];
        for (int i = 0; i < room.size(); i++) {
            Integer tCnt = room.get(i);
            pq[i] = new PriorityQueue<>();
            for (int z = 0; z < tCnt; z++) {
                pq[i].add(0);
            }
        }
        for (int[] req : reqs) {
            int st = req[0];
            int et = req[1];
            int roomNum = req[2] - 1;

            int time = pq[roomNum].poll();

            if (time > st) {
                timeCnt += time - st;
                pq[roomNum].offer(time + et);
            } else if (time < st) {
                pq[roomNum].offer(st + et);
            } else {
                pq[roomNum].offer(time + et);
            }
        }

        answer = Math.min(answer, timeCnt);
    }

    // 상담사 조합
    public void combi(int L, int k, int s, int[][] reqs) {
        if (L == 0) {
            select(reqs);
        } else {
            for (int i = s; i < k; i++) {
                room.set(i, room.get(i) + 1);
                combi(L - 1, k, i, reqs);
                room.set(i, room.get(i) - 1);
            }
        }
    }

    public int solution(int k, int n, int[][] reqs) {
        for (int i = 0; i < k; i++) {
            n--;
            room.add(1);
        }

        combi(n, k, 0, reqs);

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int k = 3, n = 5;
        int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1},
                {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
        System.out.println(T.solution(k, n, reqs));
    }
}