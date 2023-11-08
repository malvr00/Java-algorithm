import java.util.*;

public class Main {
    /*
        2. 공통원소 구하기 (two pointers algorithm)
        two pointers algorithm은 정렬이 된 후에 진행 해야 함
     */

    public static List<Integer> solution(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < n) {
            if (arr1[p1] == arr2[p2]) {
                result.add(arr1[p1++]);
                p2 = 0;
                continue;
            }
            p2++;
            if (p2 == m) {
                p2 = 0;
                p1++;
            }
        }
        Collections.sort(result);
        return result;
    }

    public static List<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                result.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = kb.nextInt();
        }

        solution2(n, arr1, m, arr2).forEach(obj -> System.out.print(obj + " "));
//        System.out.println();
    }
}