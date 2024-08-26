import java.util.*;

public class Main {

    static boolean[] ch;
    static int minAnswer = Integer.MAX_VALUE;
    static StringBuilder memoAnswer = new StringBuilder();

    public void DFS(String n, int lv) {
        if (lv == n.length()) {
            int val = Integer.parseInt(memoAnswer.toString());
            if (val > Integer.parseInt(n)) {
                minAnswer = Math.min(minAnswer, val);
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                if(ch[i]) continue;
                ch[i] = true;
                memoAnswer.append(n.charAt(i));
                DFS(n, lv + 1);
                ch[i] = false;
                memoAnswer.delete(memoAnswer.length() - 1, memoAnswer.length());
            }
        }
    }

    public int solution(int n){
        minAnswer = Integer.MAX_VALUE;
        String sVal = String.valueOf(n);
        ch = new boolean[sVal.length()];

        DFS(sVal, 0);

        if (minAnswer == Integer.MAX_VALUE) {
            return -1;
        } else {
            memoAnswer.setLength(0);
            return minAnswer;
        }
    }

    int answer, target, m;
    ArrayList<Integer> nums;
    int[] ch2;
    boolean flag2;
    public void DFS(int L, int number){
        if(flag2) return;
        if(L == m){
            if(number > target){
                answer = number;
                flag2 = true;
            }
        }
        else{
            for(int i = 0; i < m; i++){
                if(ch2[i] == 0){
                    ch2[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch2[i] = 0;
                }
            }
        }
    }
    public int solution(int n, int version){
        answer = 0;
        flag2 = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while(tmp > 0){
            int t = tmp%10;
            nums.add(t);
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> a - b);
        m = nums.size();
        ch2 = new int[m];
        DFS(0, 0);
        if(flag2 == false) return -1;
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}