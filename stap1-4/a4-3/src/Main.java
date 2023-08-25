import java.util.*;

public class Main {
    /*
        2. 아나그램(HashMap)
     */

    public static List<Integer> solution(int n, int m, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex;
        for (startIndex = 0; startIndex < m; startIndex++) {
            map.put(arr[startIndex], map.getOrDefault(arr[startIndex], 0) + 1);
        }
        answer.add(map.size());

        for (; startIndex < n; startIndex++) {
            map.put(arr[startIndex - m], map.get(arr[startIndex - m]) - 1);
            map.put(arr[startIndex], map.getOrDefault(arr[startIndex], 0) + 1);
            if (map.get(arr[startIndex - m]) < 1) {
                map.remove(arr[startIndex - m]);
            }
            answer.add(map.size());
        }

        return answer;
    }

    public static List<Integer> solution2(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0));
        }

        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            answer.add(hm.size());

            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0) {
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }

        solution(n, m, arr1).forEach(obj -> System.out.print(obj + " "));
    }
}