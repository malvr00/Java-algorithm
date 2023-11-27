import java.util.*;

public class Main {

    /**
     * Level2
     * 피로도
     */
    static int answer = 0;
    static int[] ch;

    public void DFS(int lv, int lvMax, int fatigue, int[][] dungeons, int cnt) {
        if (lv == lvMax) {
            answer = Math.max(answer, cnt);
        } else {
            for (int i = 0; i < lvMax; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    if (fatigue >= dungeons[i][0]) {
                        DFS(lv + 1, lvMax, fatigue - dungeons[i][1], dungeons, ++cnt);
                        cnt--;
                    } else {
                        DFS(lv + 1, lvMax, fatigue, dungeons, cnt);
                    }
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        ch = new int[dungeons.length];

        DFS(0, dungeons.length, k, dungeons, 0);

        return answer;
    }

    public static void main(String[] args) {
        /*
            k	dungeons	                result
            80	[[80,20],[50,40],[30,10]]	3
         */
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        Main main = new Main();
        System.out.println(main.solution(k, dungeons));
    }
}