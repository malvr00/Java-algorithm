import java.util.*;

class Node {
    int idx;
    int weight;

    public Node (int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }

}
public class Main {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Node(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            boolean flag = true;
            Node poll = q.poll();

            for (Node node : q) {
                if (node.weight > poll.weight) {
                    q.offer(poll);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
                if (poll.idx == location) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            priorities	        location	return
            [2, 1, 3, 2]	    2	        1
            [1, 1, 9, 1, 1, 1]	0	        5
         */
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        Main main = new Main();
        int solution = main.solution(priorities, location);

        System.out.println(solution);
    }
}