import java.util.*;

public class Main {
    /*
        3. 팩토리얼
     */

    public static int solution(int n) {

        int answer = 0;
        if (n == 0) {
            return 1;
        } else {
            answer = solution(n - 1) * n;
        }
        return answer;
    }

    public static int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        System.out.println(solution(n));
    }
}