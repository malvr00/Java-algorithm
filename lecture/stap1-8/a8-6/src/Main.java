import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /*
        6. 순열 구하기
     */

    static int r = 0;
    static int[] answer;
    static int[] ch;
    public static void solution(int l, int[] arr) {

        if (l == r) {
            for (int i = 0; i < answer.length; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] > 0) {
                    continue;
                }
                answer[l] = arr[i];
                ch[i] = 1;
                solution(l + 1, arr);
                ch[i] = 0;
            }
        }
    }

    static int[] pm, ch2, arr2;
    static int n2, m2;
    public static void DFS(int L) {
        if (L == m2) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n2; i++) {
                if (ch[i] == 0) {
                    ch2[i] = 1;
                    pm[L] = arr2[i];
                    DFS(L + 1);
                    ch2[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();   // n2
        r = kb.nextInt();       // m2
        int[] arr = new int[n]; // arr2

        answer = new int[r];    // pm
        ch = new int[n];        // ch2

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        solution(0, arr);
    }
}