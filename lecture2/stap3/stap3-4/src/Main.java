import java.util.*;

public class Main {

    /**
     * 강의.
     * 피부과 ( 자료규조 활용 )
     */
    public int getTime(String time) {
        int sTime = Integer.parseInt(time.split(":")[0]);
        int eTime = Integer.parseInt(time.split(":")[1]);

        return sTime * 60 + eTime;
    }
    public int solution(int[] laser, String[] enter){
        // enter의 길이가 길어지면 성능이 크게 떨어짐.
        int answer = 0;

        for (int i = 0 ; i < enter.length; i++) {
            int state = Integer.parseInt(enter[i].split(" ")[1]);
            int time = getTime(enter[i].split(" ")[0]) + laser[state];

            int cnt = 0;
            if(answer > enter.length - answer) break;
            for (int j = i + 1; j < enter.length; j++) {
                int nTime = getTime(enter[j].split(" ")[0]);

                if (time > nTime) {
                    cnt++;
                } else {
                    break;
                }
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    public int solution(int[] laser, String[] enter, int version){
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];
        for(int i = 0; i < n; i++){
            int a = getTime(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(inList[0][1]);
        int fT = inList[0][0];
        int pos = 1;
        for(int t = fT; t <= 1200; t++){
            if(pos < n && t == inList[pos][0]){
                if(Q.isEmpty() && inList[pos][0] > fT) fT= inList[pos][0];
                Q.offer(inList[pos][1]);
                pos++;
            }
            if(t == fT && !Q.isEmpty()){
                int idx = Q.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, Q.size());
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2",
                "10:52 3", "11:10 2"}, 2));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2",
                "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1",
                "11:20 1", "11:40 1"}));
    }
}