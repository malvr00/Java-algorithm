import java.util.*;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}


public class Main {
    /*
        8. 응급실
     */

    public static int solution(int n, int m, int[] p) {
        // 중복 위험도 있을 시 M번째 환자 정확히 출력 못 하는 문제
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int my = p[m];
        for (int x : p) {
            q.offer(x);
        }

        for (int i = 0; i < n; i++) {
            int now = q.poll();
            int next = 0;
            for (int j = 0; j < q.size(); j++) {
                next = q.poll();
                if (now <= next) {
                    q.offer(now);
                    now = next;
                } else {
                    q.offer(next);
                }
            }
            answer++;
            if (now == my) {
                if (!q.contains(my)) {
                    break;
                }
            }
        }

        return answer;
    }

    public static int solution2(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
            Person tmp = q.poll();
            for (Person x : q) {
                if (x.priority > tmp.priority) {
                    q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = kb.nextInt();
        }

        System.out.println(solution2(n, m, p));
    }
}