import java.util.*;


class Record implements Comparable<Record>{

    int time;
    int carNum;
    char state;

    public Record(int time, int carNum, char state) {
        this.time = time;
        this.carNum = carNum;
        this.state = state;
    }

    @Override
    public int compareTo(Record obj) {
        return this.carNum - obj.carNum;
    }

}

public class Main {

    /**
     * Level2.
     * 주차 요금 계산
     */
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int maxTime = 2359;
        List<Record> recoList = new ArrayList<>();
        HashMap<Integer, Integer> carMap = new HashMap<>();

        for (String x : records) {
            String[] s = x.split(" ");
            int time = Integer.parseInt(s[0].replace(":", ""));
            int carNum = Integer.parseInt(s[1]);
            char state = s[2].equals("IN") ? 's' : 'e';
            recoList.add(new Record(time, carNum, state));
            carMap.put(carNum, carMap.getOrDefault(carNum, 0) + 1);
        }

        Collections.sort(recoList);

        List<Integer> carNumInfo = new ArrayList<>(carMap.keySet());
        Collections.sort(carNumInfo);
        answer = new int[carNumInfo.size()];


        for (int idx = 0; idx < carNumInfo.size(); idx++) {
            int car = carNumInfo.get(idx);
            int in = -1;
            int cnt = 0;
            int sumTime = 0;
            for (Record record : recoList) {
                if (record.carNum == car) {
                    cnt++;
                    if (record.state == 's') {
                        in = record.time;

                        if (cnt == carMap.get(car)) {
                            sumTime += getSumTime(in, maxTime);
                            break;
                        }

                    } else {
                        int out = record.time;

                        sumTime += getSumTime(in, out);
                    }
                }
            }
            int val1 = fees[1];
            double min = ((double)sumTime - (double)fees[0]) / (double)fees[2];
            int val2 = (int) Math.ceil(min);
            int val3 = fees[3];
            if (sumTime > fees[0]) {
                answer[idx] = val1 + val2 * val3;
            } else {
                answer[idx] = val1;
            }
        }

        return answer;
    }

    public int getSumTime(int inTime, int outTime) {
        int rHour = 0;
        int rMin = 0;

        int inHour = inTime / 100;
        int inMin = inTime % 100;
        int outHour = outTime / 100;
        int outMin = outTime % 100;

        if (outMin < inMin) {
            outHour--;
            int tmpMin = 60 - inMin;
            rMin = outMin + tmpMin;
        } else {
            rMin = outMin - inMin;
        }
        rHour = outHour - inHour;
        if (rHour > 0) {
            rMin += rHour * 60;
        }

        return rMin;
    }

    public static void main(String[] args) {
        /*
            fees	                records	                                result
            [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN",      [14600, 34400, 5000]
                                     "06:34 0000 OUT", "07:59 5961 OUT",
                                     "07:59 0148 IN", "18:59 0000 IN",
                                     "19:09 0148 OUT", "22:59 5961 IN",
                                     "23:00 5961 OUT"]
            [120, 0, 60, 591]	    ["16:00 3961 IN","16:00 0202 IN",       [0, 591]
                                     "18:00 3961 OUT","18:00 0202 OUT",
                                     "23:58 3961 IN"]
            [1, 461, 1, 10]	        ["00:00 1234 IN"]	                    [14841]
         */
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        Main main = new Main();
        int[] solution = main.solution(fees, records);
        for (int x : solution) {
            System.out.print(x);
        }
    }
}