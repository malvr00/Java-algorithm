import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Level2.
     * [1차] 캐시 ( KAKAO )
     */
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> arr = new ArrayList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            if (arr.remove(city.toUpperCase())) {
                answer += 1;
                arr.add(city.toUpperCase());
            } else {
                answer += 5;
                if (arr.size() >= cacheSize) {
                    arr.remove(0);
                }
                arr.add(city.toUpperCase());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            캐시크기(cacheSize)	    도시이름(cities)	                            실행시간
            3	                    ["Jeju", "Pangyo", "Seoul", "NewYork",          50
                                    "LA", "Jeju", "Pangyo", "Seoul", "NewYork",
                                    "LA"]
            3	                    ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",   21
                                    "Seoul", "Jeju", "Pangyo", "Seoul"]
            2	                    ["Jeju", "Pangyo", "Seoul", "NewYork", "LA",    60
                                    "SanFrancisco", "Seoul", "Rome", "Paris",
                                    "Jeju", "NewYork", "Rome"]
            5	                    ["Jeju", "Pangyo", "Seoul", "NewYork", "LA",    52
                                    "SanFrancisco", "Seoul", "Rome", "Paris",
                                    "Jeju", "NewYork", "Rome"]
            2	                    ["Jeju", "Pangyo", "NewYork", "newyork"]	    16
            0	                    ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]	25
         */
        int cacheSize = 0;
        String[] cities = {"Jeju", "Jeju", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        Main main = new Main();
        int solution = main.solution(cacheSize, cities);
        System.out.println(solution);
    }
}