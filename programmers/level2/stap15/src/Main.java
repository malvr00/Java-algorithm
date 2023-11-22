import java.util.*;

public class Main {

    /**
     * Level2.
     * 할인행사
     */
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        final int MAX = 10;
        int cnt = 0;
        int lt = 0;

        for (int i = 0; i < discount.length; i++) {
            cnt++;
            int idx = findIndex(want, discount[i]);
            if (idx > -1) {
               number[idx] -= 1;
            }
            if (cnt == MAX) {
                if (zeroCheck(number)) {
                    answer++;
                }
                int idx2 = findIndex(want, discount[lt]);
                if (idx2 > -1) {
                    number[idx2] += 1;
                }
                lt++;
                cnt--;
            }
        }
        return answer;
    }

    public static int findIndex(String[] arr, String strFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(strFind)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean zeroCheck(int[] arr) {
        for (int j : arr) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        /*
            want	                    number              discount	                            result
            ["banana", "apple",         [3, 2, 2, 2, 1]     ["chicken", "apple", "apple",           3
            "rice", "pork", "pot"]	    	                "banana", "rice", "apple", "pork",
                                                            "banana", "pork", "rice", "pot",
                                                            "banana", "apple", "banana"]

            ["apple"]	                [10]                ["banana", "banana", "banana",          0
                                                            "banana", "banana", "banana",
                                                            "banana", "banana", "banana", "banana"]
         */
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple",
                "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        Main main = new Main();
        int solution = main.solution(want, number, discount);
        System.out.println(solution);
    }
}