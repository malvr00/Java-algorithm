import java.util.*;

class Times implements Comparable<Times>{
    int sd, ed;

    public Times(int sd, int ed) {
        this.sd = sd;
        this.ed = ed;
    }

    @Override
    public int compareTo(Times o) {

        if (this.ed == o.ed) {
            return this.sd - o.sd;
        } else {
            return this.ed - o.ed;
        }
    }
}
public class Main {

    /*
        2. 회의실 배정
     */

    public static int solution(int n, List<Times> arr) {
        // 틀림 100,000 이상 시 타임 아웃 발생
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);

        for (int i = 0; i < n; i++) {
            int val = 1;
            Times tmp = arr.get(i);
            for (int j = i + 1; j < n; j++) {
                if (tmp.ed <= arr.get(j).sd) {
                    val++;
                    tmp = arr.get(j);
                }
            }
            answer = Math.max(answer, val);
        }

        return answer;
    }

    public static int solution2(int n, List<Times> arr) {
        int cnt = 0;
        Collections.sort(arr);
        int et = 0;
        for (Times ob : arr) {
            if (ob.sd >= et) {
                cnt++;
                et = ob.ed;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        List<Times> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sd = kb.nextInt();
            int ed = kb.nextInt();
            arr.add(new Times(sd, ed));
        }

        System.out.println(solution(n, arr));
    }
}