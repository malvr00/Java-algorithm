import java.util.*;

public class Main {
    /*
        6. 장난꾸러기
     */

    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[2];

        int cnt = 1;
//        for (int i = 0; i < n - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                answer[cnt] = i + cnt + 1;
//                cnt++;
//            }
//            if (cnt > 1) {
//                break;
//            }
//        }

        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                answer[cnt] = i + 1;
                cnt--;
                while (cnt == 0) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;

                    i--;
                    if (arr[i] >= arr[i - 1]) {
                        answer[cnt] = i + 1;
                        cnt--;
                    }
                }
            }
            if (cnt < 0) {
                break;
            }
        }
        return answer;
    }

    public static List<Integer> solution2(int size, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < size; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = kb.nextInt();
        }

        List<Integer> answer = solution2(n, p);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
//        System.out.println();
    }
}