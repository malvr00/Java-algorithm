import java.util.*;

public class Main {

    /**
     * Level2.
     * 연속 부분 수열 합의 개수
     */
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int rt = i;
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k <= rt; k++) {
                    sum += elements[k >= elements.length ? k - elements.length : k];
                }
                set.add(sum);
                rt++;
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        /*
            elements	    result
            [7,9,1,1,4]	    18
         */
        Main main = new Main();
        int[] arr = {7,9,1,1,4};
        int solution = main.solution(arr);
        System.out.println(solution);
    }
}