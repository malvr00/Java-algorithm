import java.util.*;

class Time implements Comparable<Time>{
    int s, e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.s == o.s) {
            return this.e - o.e;
        } else {
            return this.s - o.s;
        }
    }
}

class Time2 implements Comparable<Time2> {
    public int time;
    public char state;

    public Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time2 ob) {
        if(this.time == ob.time) return this.state - ob.state;
        else return this.time - ob.time;
    }
}
public class Main {

    /*
        3. 결혼식
     */

    public static int solution(int n, List<Time> arr) {
        // 문제 3,4,5 실패
        int answer = Integer.MIN_VALUE;
        int p = 1;
        Collections.sort(arr);

        int pt = 0;
        for (int i = 1; i < n; i++) {
            Time tmp = arr.get(i);
            if (tmp.s < arr.get(pt).e) {
                p++;
                answer = Math.max(answer, p);
            } else {
                p--;
                i--;
                pt++;
            }
        }

        return answer;
    }

    public static int solution2(List<Time2> arr) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Time2 ob : arr) {
            if (ob.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        List<Time2> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();

            arr.add(new Time2(s, 's'));
            arr.add(new Time2(e, 'e'));
        }

        System.out.println(solution2(arr));
    }
}