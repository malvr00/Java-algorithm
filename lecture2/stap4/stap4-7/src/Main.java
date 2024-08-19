import java.util.*;

public class Main {

    public class Node implements Comparable<Node> {
        int sT;
        int eT;

        public Node(int sT, int eT) {
            this.sT = sT;
            this.eT = eT;
        }
        @Override
        public int compareTo(Node obj) {
            if (this.sT == obj.sT) {
                return this.eT - obj.sT;
            } else {
                return this.sT - obj.sT;
            }
        }
    }
    public int solution(int[][] meetings){
        List<Node> list = new ArrayList<>();
        for (int[] val : meetings) {
            list.add(new Node(val[0], val[1]));
        }
        Collections.sort(list);

        PriorityQueue<Integer> room = new PriorityQueue<>();
        for (Node node : list) {
            if (room.isEmpty()) {
                room.add(node.eT);
            } else {
                if (room.peek() <= node.sT) {
                    room.poll();
                }
                room.add(node.eT);
            }
        }

        return room.size();
    }

    public int solution(int[][] meetings, int version){
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] x : meetings){
            list.add(new int[]{x[0], 1});
            list.add(new int[]{x[1], 2});
        }
        list.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int answer = 0, cnt = 0;
        for(int[] x : list){
            if(x[1] == 1) cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{0, 10}, {20, 25}, {5, 15}, {2, 5}}, 2));
        System.out.println(T.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
        System.out.println(T.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
        System.out.println(T.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    }
}