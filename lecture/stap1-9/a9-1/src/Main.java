import java.util.*;

class UserInfo implements Comparable<UserInfo>{
    int k, w;

    public UserInfo(int k, int w) {
        this.k = k;
        this.w = w;
    }

    @Override
    public int compareTo(UserInfo o) {
        return o.k - this.k;
    }
}

public class Main {

    /*
        1. 씨름 선수
     */
    public static int solution(int n, List<UserInfo> users) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            UserInfo userA = users.get(i);
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                UserInfo userB = users.get(j);
                if (userA.k < userB.k && userA.w < userB.w) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }
        return answer;
    }

    public static int solution2(int n, List<UserInfo> users) {
        int cnt = 0;
        Collections.sort(users);
        int max = Integer.MIN_VALUE;

        for (UserInfo ob : users) {
            if (ob.w > max) {
                max = ob.w;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        List<UserInfo> users = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int k = kb.nextInt();
            int w = kb.nextInt();
            users.add(new UserInfo(k, w));
        }

        System.out.println(solution(n, users));
    }
}