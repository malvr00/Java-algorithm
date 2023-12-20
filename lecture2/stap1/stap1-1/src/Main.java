import java.util.*;

public class Main {

    /**
     * 시뮬레이션 & 구현
     * 사다리타기 게임
     */
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        List<ArrayList<ArrayList<Integer>>> list = new ArrayList<>();

        for (int i = 0; i < ladder.length; i++) {
            // 사다리 조립
            list.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                list.get(i).add(new ArrayList<>());
            }

            for (int j = 0; j < ladder[i].length; j++) {
                list.get(i).get(ladder[i][j]).add(ladder[i][j] + 1);
                list.get(i).get(ladder[i][j] + 1).add(ladder[i][j]);
            }
        }

        // 사다리 시작
        for (int i = 0; i < n; i++) {
            char user = (char) (65 + i);
            int pos = i + 1;

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).get(pos).size() != 0) {
                    pos = list.get(j).get(pos).get(0);
                }
            }

            answer[pos - 1] = user;
        }

        return answer;
    }

    public char[] solution2(int n, int[][] ladder){
        // 강의
        char[] answer = new char[n]; for(int i = 0; i < n; i++){
            answer[i] = (char)(i + 65);
        }
        for(int[] line : ladder){
            for(int x : line){
                char tmp = answer[x];
                answer[x] = answer[x-1];
                answer[x-1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        // answer ['D', 'B', 'A', 'C', 'E']
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        // answer ['A', 'C', 'B', 'F', 'D', 'G', 'E']
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        // answer ['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        // answer ['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11},
                                                                            {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}