import java.util.*;

public class Main {

    /**
     * 강의.
     * 경고 메일 ( 해쉬, 시간파싱 )
     */
    public int getTime(String sTime) {
        int startT = Integer.parseInt(sTime.split(":")[0]);
        int endT = Integer.parseInt(sTime.split(":")[1]);

        return startT * 60 + endT;

    }
    public String[] solution(String[] reports, int time){
        String[] answer = {};
        Map<String, ArrayList<String>> reportMap = new HashMap<>();

        for (String s : reports) {
            String[] val = s.split(" ");

            reportMap.putIfAbsent(val[0], new ArrayList<>());

            reportMap.get(val[0]).add(val[1] + " " + val[2]);
        }

        List<String> answerL = new ArrayList<>();
        for (String key : reportMap.keySet()) {
            int startT = 0;
            int cumulativeT = 0;
            for (String val : reportMap.get(key)) {
                String[] info = val.split(" ");
                if (info[1].equals("in")) {
                    startT = getTime(info[0]);
                } else {
                    int endT = getTime(info[0]);
                    cumulativeT += (endT - startT);
                }
            }
            if (cumulativeT > time) {
                answerL.add(key);
            }
        }

        Collections.sort(answerL);

        return answerL.toArray(answer);
    }

    public String[] solution(String[] reports, int time, int version){
        //String[] answer ={};
        HashMap<String, Integer> inT = new HashMap<>();
        HashMap<String, Integer> sumT = new HashMap<>();
        for(String x : reports){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];
            if(c.equals("in")) inT.put(a, getTime(b));
            else sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - inT.get(a)));
        }
        ArrayList<String> res = new ArrayList<>();
        for(String name : sumT.keySet()){
            if(sumT.get(name) > time) res.add(name);
        }
        res.sort((a, b) -> a.compareTo(b));
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in",
                "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out",
                "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in",
                "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out",
                "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in",
                "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in",
                "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in",
                "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out",
                "daniel 15:05 out"}, 60)));
    }
}