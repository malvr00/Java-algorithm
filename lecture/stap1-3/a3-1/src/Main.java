import java.util.*;

public class Main {
    /*
        1. 두 배열 합치기
     */

    public static int[] solution(int n, int[] arr1, int m, int[] arr2) {
        int result = 0;
        int[] newArr = new int[n + m];
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            newArr[lastIndex] = arr1[i];
            lastIndex++;
        }

        for (int i = 0; i < m; i++) {
            newArr[lastIndex] = arr2[i];
            lastIndex++;
        }

        for (int i = 0; i < lastIndex; i++) {
            int tmp = newArr[i];
            for (int j = 0; j < lastIndex; j++) {
                if (tmp < newArr[j]) {
                    newArr[i] = newArr[j];
                    newArr[j] = tmp;
                    tmp = newArr[i];
                }
            }
        }

        return newArr;
    }

    public static List<Integer> solution2(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                result.add(arr1[p1++]);
            } else {
                result.add(arr2[p2++]);
            }
        }
        while (p1 < n) {
            result.add(arr1[p1++]);
        }
        while (p2 < m) {
            result.add(arr2[p2++]);
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

        for (int i = 0; i < solution(n, arr1, m, arr2).length; i++) {
            System.out.print(solution(n, arr1, m, arr2)[i] + " ");
        }
//        System.out.println();
    }
}