import java.util.*;

public class Main {

    /**
     * Level3.
     * 단속 카메라
     * Greedy
     */
    public static class Node implements Comparable<Node> {
        int time;
        int idx;
        int state;

        public Node(int time, int idx, int state) {
            this.time = time;
            this.idx = idx;
            this.state = state;
        }

        @Override
        public int compareTo(Node obj) {
            if (obj.time == this.time) {
                return this.state - obj.state;
            }

            return this.time - obj.time;
        }
    }

    public int solution(int[][] routes) {
        int answer = 0;

        List<Node> list = new ArrayList<>();
        Set<Integer> outCar = new HashSet<>();
        for (int i = 0; i < routes.length; i++) {
            // 0: 진입, 1: 진출
            list.add(new Node(routes[i][0], i, 0));
            list.add(new Node(routes[i][1], i, 1));
        }
        Collections.sort(list);

        int lt = 0;
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);

            // 이미 카메라를 지나친 차량은 제외
            if(outCar.contains(cur.idx)) continue;

            if(cur.state == 1) {
                for(int j = i; j >= lt; j--){
                    Node preCur = list.get(j);
                    outCar.add(preCur.idx);
                }
                lt = i + 1;
                answer++;
            }
        }
        return answer;
    }

    public int solution2(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int lastOut = Integer.MIN_VALUE;
        for (int[] cur : routes) {
            int in = cur[0], out = cur[1];

            if (lastOut < in) {
                answer++;
                lastOut = out;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution2(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
}