import java.util.*;

public class Main {
    public int solution(int[] pool, int a, int b, int home) {
        int answer = 0;

        int min = 0;
        int max = 10000;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            answer++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                int go = now + a;
                int back = now - b;
                if (go == home || back == home) {
                    return answer;
                }

                boolean flag1 = false;
                boolean flag2 = false;
                for (int stop : pool) {
                    if (stop == go) {
                        flag1 = true;
                    }
                    if (stop == back) {
                        flag2 = true;
                    }
                }
                if(!flag1 && go <= max) q.offer(go);
                if(!flag2 && min <= back) q.offer(back);
            }
        }

        return -1;
    }


    public int solution(int[] pool, int a, int b, int home, int version){
        int[][] ch = new int[2][10001];
        for(int x : pool){
            ch[0][x] = 1;
            ch[1][x] = 1;
        }
        Queue<int[]> Q = new LinkedList<>();
        ch[0][0] = 1;
        ch[1][0] = 1;
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] cur = Q.poll();
                if(cur[0] == home) return L;
                int nx = cur[0] + a;
                if(nx <= 10001 && ch[0][nx] == 0){
                    ch[0][nx] = 1;
                    Q.offer(new int[]{nx, 0});
                }
                nx = cur[0] - b;
                if(nx >= 0 && ch[1][nx] == 0 && cur[1] == 0){
                    ch[1][nx] = 1;
                    Q.offer(new int[]{nx, 1});
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}