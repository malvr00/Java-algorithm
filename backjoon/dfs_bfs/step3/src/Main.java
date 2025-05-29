import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int answer = 0;
    private static boolean[] ch;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> nodes = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());

            nodes.get(lt).add(rt);
            nodes.get(rt).add(lt);
        }

        solution(N, M, nodes);
        System.out.print(answer);

        br.close();
    }

    public static void solution(final int N, final int M, List<ArrayList<Integer>> nodes) {
        ch = new boolean[N + 1];

        dfs(1, nodes);
    }

    public static void dfs(int root, List<ArrayList<Integer>> nodes) {
        if(ch[root]) return;

        ch[root] = true;
        for (Integer node : nodes.get(root)) {
            if(ch[node]) continue;
            answer++;
            dfs(node, nodes);
        }
    }
}