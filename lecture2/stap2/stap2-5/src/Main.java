import java.util.*;

public class Main {

    /**
     * 강의.
     * 회장 선거 ( 해싱, 시간파싱 )
     */
    public String solution(String[] votes, int k){
        Map<String, ArrayList<String>> select = new HashMap<>();
        Map<String, Integer> voteMem = new HashMap<>();
        Set<String> choice = new HashSet<>();

        for (String s : votes) {
            String[] val = s.split(" ");
            select.put(val[1], select.getOrDefault(val[1], new ArrayList<>()));
            select.get(val[1]).add(val[0]);

            if (select.get(val[1]).size() >= k) {
                choice.add(val[1]);
            }
        }

        int cnt = 0;
        for (String s : choice) {
            for (String tmp : select.get(s)) {
                voteMem.put(tmp, voteMem.getOrDefault(tmp, 0) + 1);
                cnt = Math.max(cnt, voteMem.get(tmp));
            }
        }

        List<String> maxCntMem = new ArrayList<>();
        for (String s : voteMem.keySet()) {
            if (cnt == voteMem.get(s)) {
                maxCntMem.add(s);
            }
        }

        if (maxCntMem.size() > 1) {
            Collections.sort(maxCntMem);
        }

        return maxCntMem.get(0);
    }

    public String solution(String[] votes, int k, int version){
        String answer = " ";
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();
        for(String x : votes){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            voteHash.putIfAbsent(a, new HashSet<String>());
            voteHash.get(a).add(b);
            candidate.put(b, candidate.getOrDefault(b, 0) + 1);
        }
        int max=Integer.MIN_VALUE;
        for(String a : voteHash.keySet()){
            int cnt = 0;
            for(String b : voteHash.get(a)){
                if(candidate.get(b) >= k) cnt++;
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }
        ArrayList<String> tmp = new ArrayList<>();
        for(String name : present.keySet()){
            if(present.get(name) == max) tmp.add(name);
        }
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis",
                "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom",
                "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis",
                "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis",
                "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}