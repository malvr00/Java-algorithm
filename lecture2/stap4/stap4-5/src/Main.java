import java.util.*;

public class Main {

    public class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] board){
        int answer = Integer.MAX_VALUE;

        int[] nX = {-1, 0, 1, 0};
        int[] nY = {0, 1, 0, -1};


        List<Node> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    list.add(new Node(i, j));
                }
            }
        }

        int k = list.size();
        int[][][] newBoard = new int[k][board.length][board[0].length];

        for (int i = 0; i < k; i++) {
            newBoard[i][list.get(i).x][list.get(i).y] = 0;
            for (int j = 0; j < board.length; j++) {
                for (int z = 0; z < board[j].length; z++) {
                    if (list.get(i).x != j || list.get(i).y != z) {
                        newBoard[i][j][z] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        int idx = 0;
        for (Node node : list) {
            Queue<Node> q = new LinkedList<>();
            q.offer(node);

            while (!q.isEmpty()) {
                Node poll = q.poll();
                for (int j = 0; j < nX.length; j++) {
                    int nextX = poll.x + nX[j];
                    int nextY = poll.y + nY[j];
                    if (nextX >= 0 && nextX < board.length &&
                            nextY >= 0 && nextY < board[0].length) {
                        if (newBoard[idx][nextX][nextY] > newBoard[idx][poll.x][poll.y] + 1) {
                            newBoard[idx][nextX][nextY] = newBoard[idx][poll.x][poll.y] + 1;
                            q.offer(new Node(nextX, nextY));
                        }
                    }
                }
            }
            idx++;
        }

        for (int i = 0; i < newBoard[k - 1].length; i++) {
            for (int j = 0; j < newBoard[k - 1][i].length; j++) {
                int val = 0;
                for (int z = 0; z < k; z++) {
                    val += newBoard[z][i][j];
                }
                answer = Math.min(answer, val);
            }
        }

        return answer;
    }

    public int solution(int[][] board, int version){
        int answer=0;
        int n = board.length;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        col.sort((a, b) -> a - b);
        int x = row.get(row.size() / 2);
        int y = col.get(col.size() / 2);
        for(int p : row) answer += Math.abs(x - p);
        for(int p : col) answer += Math.abs(y - p);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}, 2));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}