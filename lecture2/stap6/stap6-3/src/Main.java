import java.util.*;

public class Main {

    static int maxLv;
    static int memoAnswer;
    static int WHITE = 0;
    static int BLACK = 1;
    static boolean[] ch2;

    public void DFS(int i, int lv, int[][] cans) {
        if (maxLv == lv) {
            int white = 0;
            int black = 0;
            for (int z = 0; z < maxLv * 2; z++) {
                if(ch2[z]) white += cans[z][WHITE];
                else black += cans[z][BLACK];
            }
            memoAnswer = Math.min(memoAnswer, Math.abs(white - black));
        } else {
            for (; i < maxLv * 2; i++) {
                if(ch2[i]) continue;
                ch2[i] = true;
                DFS(i + 1, lv + 1, cans);
                ch2[i] = false;
            }
        }
    }
    public int solution(int[][] cans){
        int answer2 = 0;

        maxLv = cans.length / 2;
        memoAnswer = Integer.MAX_VALUE;
        ch2 = new boolean[cans.length];

        DFS(0, 0, cans);

        answer2 = memoAnswer == Integer.MAX_VALUE ? 0 : memoAnswer;

        return answer2;
    }

    /*
     *  ==============================================
     *                      강의
     *  ==============================================
     */
    int n, answer;
    int[] ch;
    public void DFS(int L, int s, int[][] cans, int version){
        if(L == n/2){
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(ch[i] == 1) A.add(i);
                else B.add(i);
            }
            int Asum = 0, Bsum = 0;
            for(int i = 0; i < L; i++){
                Asum += cans[A.get(i)][0];
                Bsum += cans[B.get(i)][1];
            }
            answer = Math.min(answer, Math.abs(Asum - Bsum));
        }
        else{
            for(int i = s; i < n; i++){
                ch[i] = 1;
                DFS(L + 1, i + 1, cans, 2);
                ch[i] = 0;
            }
        }
    }
    public int solution(int[][] cans, int version){
        answer = 1000000000;
        n = cans.length;
        ch = new int[n];
        DFS(0, 0, cans, 2);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
        System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
        System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
    }
}