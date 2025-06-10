import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final static int[] move = {2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        System.out.print(solution(N, K));
    }

    public static int solution(final int N, final int K) {
        final int M = 100_001;
        int[] board = new int[M];

        Arrays.fill(board, Integer.MAX_VALUE);
        board[N] = 0;

        final Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);

        while (!Q.isEmpty()) {
            Integer now = Q.poll();

            for (int i = 0; i < 3; i++) {
                int next = (i == 0) ? now * move[i] : now + move[i];

                if(next < 0 || next >= M) continue;
                if(board[next] < board[now] + 1) continue;

                board[next] = board[now] + 1;

                if(next == K) return board[next];

                Q.offer(next);
            }
        }

        return 0;
    }
}