import java.util.*;

public class Main {

    static int max = 7;
    static boolean[] ch2;
    static int memoAnswer;
    static HashMap<Integer, HashSet<Integer>> map;

    public void DFS(String students) {
        if (students.length() == max) {
            memoAnswer++;
        } else {
            for (int i = 1; i <= max; i++) {
                if(ch2[i]) continue;

                if (students.length() > 0) {
                    HashSet<Integer> fight = map.get(Character.getNumericValue(students.charAt(students.length() - 1)));
                    if (fight != null && fight.contains(i)) {
                        continue;
                    }
                }

                ch2[i] = true;
                DFS(students + i);
                ch2[i] = false;
            }
        }
    }

    /*
     *  =========================================================
     *                           2
     *  =========================================================
     */

    int[] ch;
    int[][] relation;
    int answer;
    Stack<Integer> pm;
    public void DFS(int L){
        if(L == 7) answer++;
        else{
            for(int i = 1; i < 8; i++){
                if(!pm.empty() && relation[pm.peek()][i] == 1) continue;
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm.push(i);
                    DFS(L + 1);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }
    public int solution(int[][] fight, int version){
        answer = 0;
        pm = new Stack<>();
        relation = new int[8][8];
        for(int[] x : fight){
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }
        ch = new int[8];
        DFS(0);
        return answer;
    }

    public int solution(int[][] fight){
        memoAnswer = 0;
        map = new HashMap<>();
        ch2 = new boolean[max + 1];

        for (int[] student : fight) {
            map.computeIfAbsent(student[0], k -> new HashSet<>()).add(student[1]);
            map.computeIfAbsent(student[1], k -> new HashSet<>()).add(student[0]);
        }

        DFS("");

        return memoAnswer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}