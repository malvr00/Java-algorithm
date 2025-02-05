import java.util.*;

    /**
     * 프로그래머스 레벨 3.
     * [PCCP 기출문제] 4번 / 수레 움직이기
     * BFS
     */
class Solution {
    int COL;
    int ROW;
    final int MOVE = 4;
    final int[] X = {-1, 0, 1, 0};
    final int[] Y = {0, 1, 0, -1};

    // 수레 클래스
    static class Node {
        int x;
        int y;
        boolean flag;
        int type;
        int[][] moveCh;

        public Node(int x, int y, boolean flag, int type, int[][] moveCh) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.type = type;
            this.moveCh = moveCh;
        }
    }

    // 움직임 확인 클래스
    static class MoveCheck {
        Node baseNode;
        Node relativeNode;
        boolean isMove;
        boolean isEnd;

        public MoveCheck(Node baseNode, Node relativeNode, boolean isMove, boolean isEnd) {
            this.baseNode = baseNode;
            this.relativeNode = relativeNode;
            this.isMove = isMove;
            this.isEnd = isEnd;
        }
    }
    public int[][] copyArr(int[][] maze) {
        int[][] temp = new int[maze.length][];
        for (int i = 0; i < maze.length; i++) {
            temp[i] = maze[i].clone();
        }
        return temp;
    }

    // 붙어있는 수레 확인
    public boolean nodeCheck(Node baseNode, Node relativeNode) {
        for (int i = 0; i < MOVE; i++) {
            int nX = X[i] + baseNode.x;
            int nY = Y[i] + baseNode.y;
            if(nX == relativeNode.x && nY == relativeNode.y) return true;
        }

        return false;
    }

    // 수레 움직이기
    public List<MoveCheck> moveNode(Node baseNode, Node relativeNode, int[][] maze) {
        List<MoveCheck> resultList = new ArrayList<>();

        for (int rM = 0; rM < MOVE; rM++) {
            boolean baseFlag = baseNode.flag;
            int[][] baseCh = copyArr(baseNode.moveCh);

            int nX = X[rM] + baseNode.x;
            int nY = Y[rM] + baseNode.y;

            if (!baseFlag) {
                if (nX < 0 || nY < 0 || nX >= COL || nY >= ROW) continue;
                if (baseCh[nX][nY] == 5 || baseCh[nX][nY] == baseNode.type) continue;
                if (nX == relativeNode.x && nY == relativeNode.y) continue;
            } else {
                nX = baseNode.x;
                nY = baseNode.y;
            }

            if (maze[nX][nY] == (baseNode.type + 2)) {
                baseFlag = true;
            }
            baseCh[nX][nY] = baseNode.type;

            Node newBase = new Node(nX, nY, baseFlag, baseNode.type, baseCh);

            for (int bM = 0; bM < MOVE; bM++) {
                boolean relativeFlag = relativeNode.flag;
                int[][] relativeCh = copyArr(relativeNode.moveCh);

                int nnX = X[bM] + relativeNode.x;
                int nnY = Y[bM] + relativeNode.y;

                if (!relativeFlag) {
                    if (nnX < 0 || nnY < 0 || nnX >= COL || nnY >= ROW) continue;
                    if (relativeCh[nnX][nnY] == 5 || relativeCh[nnX][nnY] == relativeNode.type) continue;
                    if (nnX == nX && nnY == nY) continue;
                } else {
                    nnX = relativeNode.x;
                    nnY = relativeNode.y;
                }

                if (maze[nnX][nnY] == (relativeNode.type + 2)) {
                    relativeFlag = true;
                }

                relativeCh[nnX][nnY] = relativeNode.type;

                Node newRelativeNode = new Node(nnX, nnY, relativeFlag, relativeNode.type, relativeCh);

                if(baseFlag && relativeFlag) {
                    resultList.add(new MoveCheck(newBase, newRelativeNode, true, true));
                    return resultList;
                }

                resultList.add(new MoveCheck(newBase, newRelativeNode, true, false));
            }
        }

        return resultList;
    }
    public int solution(int[][] maze) {
        int answer = 0;

        COL = maze.length;
        ROW = maze[0].length;

        int[][] ch = new int[COL][ROW];

        Node baseRed = null, baseBlue = null;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < COL; i++) {
            for (int j = 0; j < ROW; j++) {
                if (maze[i][j] == 1) {
                    baseRed = new Node(i, j, false, 1, null);
                } else if (maze[i][j] == 2) {
                    baseBlue = new Node(i, j, false, 2, null);
                }
                ch[i][j] = maze[i][j];
            }
        }
        baseRed.moveCh = ch;
        baseBlue.moveCh = ch;

        q.offer(baseRed);
        q.offer(baseBlue);
        while (!q.isEmpty()) {
            answer++;
            int qSize = q.size();

            for (int i = 0; i < qSize / 2; i++) {
                Node node1 = q.poll();
                Node node2 = q.poll();

                List<MoveCheck> node1BaseList = moveNode(node1, node2, maze);
                for (MoveCheck moveCheck : node1BaseList) {
                    if (moveCheck.isMove) {
                        q.offer(moveCheck.baseNode);
                        q.offer(moveCheck.relativeNode);
                    }
                    if (moveCheck.isEnd) return answer;
                }
                if (nodeCheck(node1, node2)) {
                    List<MoveCheck> node2BaseList = moveNode(node2, node1, maze);
                    for (MoveCheck moveCheck : node2BaseList) {
                        if (moveCheck.isMove) {
                            q.offer(moveCheck.baseNode);
                            q.offer(moveCheck.relativeNode);
                        }
                        if (moveCheck.isEnd) return answer;
                    }
                }
            }
        }
        return 0;
    }

    static public void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{1, 4}, {0, 0}, {2, 3}}));
    }

}