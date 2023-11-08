import java.util.*;

class Block implements Comparable<Block>{
    public int a;   // 넓이
    public int h;   // 높이
    public int w;   // 무게

    Block(int a, int h, int w) {
        this.a = a;
        this.h = h;
        this.w = w;
    }

    public int compareTo(Block ob) {
        return ob.a - this.a;
    }

}

public class Main {

    /*
        4. 가장 높은 탑 쌓기(LIS 응용)
     */
    static int[] dy;
    public static int solution(int n, ArrayList<Block> blocks) {
        int answer = 0;
        Collections.sort(blocks);
        dy[0] = blocks.get(0).h;
        answer = dy[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (blocks.get(i).w < blocks.get(j).w) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + blocks.get(i).h;

            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Block> blocks = new ArrayList<>();
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int h = kb.nextInt();
            int w = kb.nextInt();

            blocks.add(new Block(a, h, w));
        }

        System.out.println(solution(n, blocks));
    }
}