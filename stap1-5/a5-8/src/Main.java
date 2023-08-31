import java.util.*;

public class Main {
    /*
        7. 교육과정 설계
     */

    public static String solution(String str1, String str2) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        for (char x : str1.toCharArray()) {
            q.offer(x);
        }

        for (char x : str2.toCharArray()) {
            Character peek = q.peek();
            if (!q.contains(x)) {
                continue;
            }
            if (x == peek) {
                q.poll();
            } else {
                return "NO";
            }
        }

        if (q.size() > 0) {
            return "NO";
        }



        return answer;
    }

    public static String solution2(String need, String plan) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for (char x : need.toCharArray()) {
            q.offer(x);
        }
        for (char x : plan.toCharArray()) {
            if (q.contains(x)) {
                if (x != q.poll()) {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            return "NO";
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str1 = kb.nextLine();
        String str2 = kb.nextLine();

        System.out.println(solution(str1, str2));
    }
}