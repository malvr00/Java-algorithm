import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        List<Set<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodes.get(u).add(v);
            nodes.get(v).add(u);
        }

        System.out.println(solution(N, M, nodes));

        br.close();
    }

    public static int solution(int N, int M, List<Set<Integer>> nodes) {
        int min = Integer.MAX_VALUE;
        int node = 101;
        for (int i = 1; i <= N; i++) {
            int cnt = BFS(N, i, nodes);
            if(min > cnt) {
                min = cnt;
                node = i;
            }
        }

        return node;
    }

    public static int BFS(final int N, final int target, List<Set<Integer>> nodes) {
        /*
            2 - 3 - 1
                | - 4 - 5
         */
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);
        dist[target] = 0;

        while (!queue.isEmpty()) {
            Integer root = queue.poll();

            for (Integer node : nodes.get(root)) {
                if(dist[node] != -1) continue;

                dist[node] = dist[root] + 1;
                queue.offer(node);
            }
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) sum += dist[i];

        return sum;
    }
}