import java.util.*;


class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }

}
public class Main {
    /*
        10. Tree 말단노드까지의 까장 짧은 경로(BFS)
     */
    Node root;

    public static void solution(int n) {

    }

    public static int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();

        Q.offer(root);
        int l = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return l;
                }
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            l++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.lt.lt = new Node(3);
        tree.root.lt.rt = new Node(4);
        tree.root.rt = new Node(5);
        System.out.println(BFS(tree.root));
    }
}