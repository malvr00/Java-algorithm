import java.util.*;

public class Main {

    public int solution(int s, int e){
        int answer = 0;

        int songMove = 1;
        final int MIN = 0;
        final int MAX = 200000;
        boolean[] ch = new boolean[200001];

        Queue<Integer> q = new LinkedList<>();

        ch[s] = true;

        q.offer(s);

        while (!q.isEmpty()) {
            answer++;

            e += songMove++;
            int size = q.size();

            if(e > MAX) return -1;

            for (int i = 0; i < size; i++) {
                int x = q.poll();

                int go = x + 1;
                int back = x - 1;
                int jump = x * 2;

                if(e == x || e == go || e == back || e == jump) return answer;

                if (go <= MAX && !ch[go]) {
                    q.offer(go);
                    ch[go] = true;
                }
                if (back >= MIN && !ch[back]) {
                    q.offer(back);
                    ch[back] = true;
                }
                if (jump <= MAX && !ch[jump]) {
                    q.offer(jump);
                    ch[jump] = true;
                }
            }
        }

        return -1;
    }


    public int solution(int s, int e, int version){
        int[][] ch = new int[2][200001];
        Queue<Integer> Q = new LinkedList<>();
        ch[0][s] = 1;
        Q.offer(s);
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            L++;
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int nx : new int[]{x-1, x+1, x*2}){
                    if(nx >= 0 && nx <= 200000 && ch[L%2][nx] == 0){
                        ch[L%2][nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L%2][e] == 1) return L;
        }
        return -1;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}