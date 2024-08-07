import java.sql.Array;
import java.util.*;

public class Main {

    public class Node implements Comparable<Node>{
        int idx;
        int sT;
        int pyT;

        public Node(int idx, int sT, int pyT) {
            this.idx = idx;
            this.sT = sT;
            this.pyT = pyT;
        }

        @Override
        public int compareTo(Node o) {
            if (this.pyT == o.pyT) {
                return this.idx - o.idx;
            } else {
                return this.pyT - o.pyT;
            }
        }
    }

    public int[] solution(int[][] tasks){
        int[] answer = new int[tasks.length];

        Map<Integer, List<Node>> map = new HashMap<>();

        int idx = 0;
        for (int[] task : tasks) {
//            List<Node> nodeList = map.getOrDefault(task[0], new ArrayList<>());
//            nodeList.add(new Node(idx, task[0], task[1]));
//            map.put(task[0], nodeList);
            Node node = new Node(idx, task[0], task[1]);
            map.computeIfAbsent(task[0], k -> new ArrayList<>()).add(node);

            idx++;
        }

        idx = 0;
        int sec = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (idx < tasks.length) {
            int plus = 1;
            if (!pq.isEmpty()) {
                Node poll = pq.poll();
                answer[idx++] = poll.idx;
                plus = poll.pyT;
            }
            int maxSec = sec + plus;
            for (; sec < maxSec; sec++) {
                List<Node> nodes = map.get(sec);
                if (nodes != null && !nodes.isEmpty()) {
                    nodes.forEach(pq::offer);
                }
            }
        }

        return answer;
    }

    public int[] solution(int[][] tasks, int version){
        int n = tasks.length;
        int[] answer = new int[n];
        LinkedList<int[]> programs = new LinkedList<>();
        for(int i = 0; i < n; i++){
            programs.add(new int[]{tasks[i][0], tasks[i][1], i});
        }
        programs.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int fT = 0, idx = 0;
        while(!programs.isEmpty() || !pq.isEmpty()){
            if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
            while(!programs.isEmpty() && programs.peek()[0] <= fT){
                int[] x = programs.pollFirst();
                pq.add(new int[]{x[1], x[2]});
            }
            int[] ex = pq.poll();
            fT = fT + ex[0];
            answer[idx++] = ex[1];
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
    }
}