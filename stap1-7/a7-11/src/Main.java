import java.util.*;


public class Main {
    /*
        11. 경로탐색(인접리스트, ArrayList)
     */

    static int n;
    static int m;
    static List<ArrayList<Integer>> graph;
    static int answer = 0;
    static int[] ch;

    public static void solution(int n) {

    }

    public static void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}