import java.util.*;

public class Main {
    /*
        2. 이진수 출력(재귀)
     */

    public static void solution(int n) {

        if(n == 0) return;

        int quotient = n / 2;
        int remainder = n % 2;
        solution(quotient);

        System.out.print(remainder);



    }

    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2);
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        solution(n);
    }
}