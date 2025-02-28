public class Main {

    /**
     * 네트워크
     * Level3.
     * DFS
     */

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] ch = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                dfs(i, computers, n, ch);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int cur, int[][] computers, int n, boolean[] ch) {
        ch[cur] = true;

        for (int i = 0; i < n; i++) {
            if(computers[cur][i] == 1 && !ch[i]) dfs(i, computers, n, ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}