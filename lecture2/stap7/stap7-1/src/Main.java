import java.util.*;

public class Main {

    public int solution(int[] nums){
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(nums[0]);

        while (true) {
            answer++;
            int size = q.size() / 2;
            for (int i = 0; i < size; i++) {
                Integer nowIdx = q.poll();
                Integer nowTail = q.poll();
                if(nowIdx == nowTail) continue;

                for (int nextTail = nowTail; nextTail > nowIdx; nextTail--) {
                    if(nextTail >= nums.length) continue;
                    if(nextTail == nums.length - 1) return answer;
                    q.offer(nextTail);
                    q.offer(nums[nextTail] + nextTail);
                }
            }
            if(q.isEmpty()) return -1;
        }
    }

    public int solution(int[] nums, int version){
        int n = nums.length;
        int[] ch = new int[n];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        ch[0] = 1;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int x = Q.poll();
                for(int j = 1; j <= nums[x]; j++){
                    int nx = x+j;
                    if(nx == n-1) return L + 1;
                    if(nx < n && ch[nx] == 0){
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}