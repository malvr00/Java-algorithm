import java.util.*;

public class Main {
    /*
        1. 학급 회장
     */

    public static Character solution(int n, String arr) {
        Character answer = null;
        Integer vote = 0;
        HashMap<Character, Integer> stu = new HashMap<>();
        stu.put('A', 0);
        stu.put('B', 0);
        stu.put('C', 0);
        stu.put('D', 0);
        stu.put('E', 0);

        for (char tmp : arr.toCharArray()) {
            Integer count = stu.get(tmp) + 1;
            stu.put(tmp, count);
        }

        for (Character tmp : stu.keySet()) {
            if (vote < stu.get(tmp)) {
                vote = stu.get(tmp);
                answer = tmp;
            }
        }

        return answer;
    }

    public static char solution2(int n, String s) {
        char answer = 0;
        HashMap<Character, Integer> stu = new HashMap<>();

        for (char x : s.toCharArray()) {
            stu.put(x, stu.getOrDefault(x, 0) + 1);
        }


        int max = Integer.MIN_VALUE;
        for (char key : stu.keySet()) {
            if (stu.get(key) > max) {
                max = stu.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        String arr1 = kb.next();

        System.out.println(solution(n, arr1));
    }
}