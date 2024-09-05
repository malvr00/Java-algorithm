import java.util.*;

public class Main {

    static public class Candy {
        int c;
        int p;

        public Candy(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public int solution(int m, List<Candy> candyList) {
        int[] dy = new int[m + 1];

        for (Candy candy : candyList) {
            for (int i = candy.p; i <= m; i++) {
                dy[i] = Math.max(dy[i], dy[i - candy.p] + candy.c);
            }
        }
        return dy[m];
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);

        List<Integer> answers = new ArrayList<>();
        while (true) {
            int n = kb.nextInt();
            int m = Math.round(kb.nextFloat() * 100);
            if( n == 0 && m == 0) {
                break;
            }
            List<Candy> candyList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int c = kb.nextInt();
                int p = (int) (kb.nextFloat() * 100);
                candyList.add(new Candy(c, p));
            }
            answers.add(main.solution(m, candyList));
        }
        for (int i = 0; i < answers.size(); i++) {
            if (i == answers.size() - 1) {
                System.out.print(answers.get(i));
            } else {
                System.out.println(answers.get(i));
            }
        }
    }
}