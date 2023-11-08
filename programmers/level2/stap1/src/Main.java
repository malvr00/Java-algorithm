import java.util.*;

public class Main {

    /**
     *  Level2.
     *  문제: 요격 시스템 ( Greedy )
     *  정답: 3
     */

    public static int solution(int[][] targets) {
        int answer = 0;

        int endPoint = Integer.MIN_VALUE;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            if(endPoint <= s){
                answer++;
                endPoint = e;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        int answer = solution(arr);

        System.out.println(answer);
    }
}