import java.util.*;

public class Main {

    /**
     * Level3.
     * 여행 경로
     * DFS
     */

    private static List<String> answer = new ArrayList<>();
    private static boolean[] ch;
    private static int n;

    private boolean check(List<String> base, List<String> cur) {
        for (int i = 0; i < base.size(); i++) {
            int sort = base.get(i).compareTo(cur.get(i));
            if(sort < 0) return true;
            else if(sort > 0) return false;
        }

        return false;
    }

    private void DFS(int L, String[][] tickets, String target, List<String> temp) {
        if (L == n) {
            if (answer.isEmpty() || !check(answer, temp)) {
                answer = new ArrayList<>(temp);
            }

        } else {
            for (int i = 0; i < n; i++) {
                if(ch[i] || !tickets[i][0].equals(target)) continue;
                ch[i] = true;
                temp.add(tickets[i][1]);

                DFS(L + 1, tickets, tickets[i][1], temp);

                temp.remove(temp.size() - 1);
                ch[i] = false;
            }
        }
    }

    public String[] solution(String[][] tickets) {
        final String FIRST_TICKET = "ICN";
        n = tickets.length;
        ch = new boolean[n];
        List<String> temp = new ArrayList<>();

        temp.add(FIRST_TICKET);
        DFS(0, tickets, FIRST_TICKET, temp);

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Main m = new Main();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(m.solution(tickets)));
    }
}