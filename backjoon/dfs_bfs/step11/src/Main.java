import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;

    private static boolean[] visited;
    private static int CNT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];

        System.out.println(solution(graph));
    }

    public static int solution(List<ArrayList<Integer>> graph) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            CNT = 0;
            DFS(i, graph);
            if(CNT > 0) answer++;
        }

        return answer;
    }

    public static void DFS(int root, List<ArrayList<Integer>> graph) {
        if(visited[root]) return;

        CNT++;
        visited[root] = true;

        for (Integer node : graph.get(root)) {
            if(visited[node]) continue;
            DFS(node, graph);
        }
    }
}