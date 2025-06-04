import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] target = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        final int M = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(temp.nextToken());
            int node = Integer.parseInt(temp.nextToken());

            nodes.get(root).add(node);
            nodes.get(node).add(root);
        }

        System.out.println(solution(N, M, target, nodes));
    }

    public static int solution(final int N, final int M, int[] target, List<ArrayList<Integer>> nodes) {
        int answer = 0;
        final int finish = target[1];
        boolean[] ch = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();

        ch[target[0]] = true;
        q.offer(target[0]);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int root = q.poll();
                if(root == finish) return answer;

                for (int n : nodes.get(root)) {
                    if(ch[n]) continue;

                    ch[n] = true;
                    q.offer(n);
                }
            }

            answer++;
        }

        return -1;
    }

}