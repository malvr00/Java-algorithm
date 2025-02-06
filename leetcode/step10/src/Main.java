import java.util.*;

public class Main {

    /**
     * Top K Frequent Elements
     */

    public static class Node implements Comparable<Node> {

        int val;
        int cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node obj) {
            return obj.cnt - this.cnt;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            pQ.offer(new Node(key, map.get(key)));
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = pQ.poll().val;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main().topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 3}, 2)));
    }
}