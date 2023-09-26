import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int time;

    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture ob) {
        return ob.time - this.time;
    }
}
public class Main {

    /*
        4. 최대 수입 스케쥴(PriorityQueue 응용문제)
     */

    static int n, max = Integer.MIN_VALUE;
    public static int solution(int n, List<Object> arr) {
        int answer = Integer.MIN_VALUE;

        return answer;
    }

    public static int solution2(List<Lecture> arr) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        Collections.sort(arr);

        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if(arr.get(j).time < i) break;
                pQ.offer(arr.get(j).money);
            }
            if (!pQ.isEmpty()) {
                answer += pQ.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arr.add(new Lecture(m, d));
            if(d > max) max = d;
        }


        System.out.println(solution2(arr));
    }
}