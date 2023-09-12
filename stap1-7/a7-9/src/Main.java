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
        9. Tree 말단노드까지의 까장 짧은 경로(DFS)
     */
    Node root;

    public static void solution(int n) {

    }

    public static int DFS(int l, Node root) {
        if (root.lt == null && root.rt == null) {
            return l;
        } else {
            return Math.min(DFS(l + 1, root.lt), DFS(l + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.lt.lt = new Node(3);
        tree.root.lt.rt = new Node(4);
        tree.root.rt = new Node(5);
        System.out.println(DFS(0, tree.root));
    }
}