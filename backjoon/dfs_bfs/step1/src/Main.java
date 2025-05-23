import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());

        int[][] nodes = new int[M][2];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st2.nextToken());
            int rt = Integer.parseInt(st2.nextToken());
            nodes[i][0] = lt;
            nodes[i][1] = rt;
        }

        solution(N, M, V, nodes);
    }

    public static void solution(final int N, final int M, final int V, int[][] nodes) {
        StringBuilder dfsSb = new StringBuilder();
        StringBuilder bfsSb = new StringBuilder();

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            list.get(nodes[i][0]).add(nodes[i][1]);
            list.get(nodes[i][1]).add(nodes[i][0]);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        DFS(V, list, new boolean[N + 1], dfsSb);
        BFS(V, list, new boolean[N + 1], bfsSb);

        System.out.println(dfsSb.delete(dfsSb.length() - 1, dfsSb.length()));
        System.out.println(bfsSb.delete(bfsSb.length() - 1, bfsSb.length()));
    }

    public static void DFS(int idx, List<ArrayList<Integer>> nodes, boolean[] ch, StringBuilder sb) {
        if(ch[idx]) return;

        ch[idx] = true;
        sb.append(idx).append(" ");

        List<Integer> list = nodes.get(idx);
        for (Integer node : list) {
            if (ch[node]) continue;
            DFS(node, nodes, ch, sb);
        }
    }

    public static void BFS(int idx, List<ArrayList<Integer>> nodes, boolean[] ch, StringBuilder sb) {
        Queue<Integer> nodeQ = new LinkedList<>();

        nodeQ.offer(idx);
        ch[idx] = true;

        while (!nodeQ.isEmpty()) {
            int root = nodeQ.poll();
            sb.append(root).append(" ");

            for (int node : nodes.get(root)) {
                if (ch[node]) continue;
                ch[node] = true;
                nodeQ.offer(node);
            }
        }
    }

}