import java.util.*;

public class Main {

    /**
     * Level3.
     * 디스크 컨트롤러
     * 우선순위 큐 + 그리디
     */

    public static class Node {

        int idx;
        int reqTime;
        int workTime;

        public Node(int idx, int reqTime, int workTime) {
            this.idx = idx;
            this.reqTime = reqTime;
            this.workTime = workTime;
        }

    }

    public int solution(int[][] jobs) {
        int answer = 0;

        final int N = jobs.length;

        List<Node> list = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++) list.add(new Node(i, jobs[i][0], jobs[i][1]));

        // 요청시간 기준
        list.sort(Comparator.comparingInt((Node x) -> x.reqTime)
                .thenComparingInt((x) -> x.workTime)
                .thenComparingInt((x) -> x.idx));

        // 작업시간 기준
        PriorityQueue<Node> pQ = new PriorityQueue<>(
                Comparator.comparingInt((Node x) -> x.workTime)
                        .thenComparingInt((x) -> x.reqTime)
                        .thenComparingInt((x) -> x.idx));

        int done = 0, time = 0, i = 0;

        while(done < N) {
            while(i < N && list.get(i).reqTime <= time) {
                pQ.offer(list.get(i++));
            }

            if(!pQ.isEmpty()) {
                Node node = pQ.poll();

                // 작업 시작시간 맞추기
                if(time < node.reqTime) time = node.reqTime;

                time += node.workTime;
                answer += (time - node.reqTime);

                done++;
            } else {
                // 작업 요청이 없으면 가장 최신의 요청으로 이동
                time = Math.max(time, list.get(i).reqTime);
            }
        }

        return (int) (answer / N);
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
    }
}