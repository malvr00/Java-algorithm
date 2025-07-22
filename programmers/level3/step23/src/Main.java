import java.util.*;

public class Main {

    /**
     * Level3.
     * 불량 사용자
     * 조합
     */

    private static int answer = 0;

    public boolean match(int idx, String[] banned_id, List<String> users, boolean[] ch) {
        if(idx == banned_id.length) return true;

        String pattern = banned_id[idx];

        for (int i = 0; i < users.size(); i++) {
            if(ch[i]) continue;
            String user = users.get(i);

            int cnt = 0;
            for (int j = 0; j < user.length(); j++) {
                if(user.length() != pattern.length()) continue;
                if(user.charAt(j) == pattern.charAt(j) || pattern.charAt(j) == '*') {
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt != user.length()) continue;

            ch[i] = true;

            if(match(idx + 1, banned_id, users, ch)) return true;

            ch[i] = false;
        }

        return false;
    }

    public void comb(int L, String[] user_id, String[] banned_id, int s, Set<String> users) {
        if (L == banned_id.length) {
            int eqCnt = 0;
            List<String> list = new ArrayList<>(users);
            boolean[] ch = new boolean[L];

            if(match(0, banned_id, list, ch)) answer++;
        } else {
            for (int i = s; i < user_id.length; i++) {
                users.add(user_id[i]);
                comb(L + 1, user_id, banned_id, i + 1, users);
                users.remove(user_id[i]);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        comb(0, user_id, banned_id, 0, new HashSet<>());

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******", "******"};

        System.out.println(m.solution(user_id, banned_id));
    }
}