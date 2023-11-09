import java.util.*;

class Room implements Comparable<Room>{
    public int time;
    public char state;

    public Room(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Room obj) {
        if (this.time == obj.time) {
            return this.state - obj.state;
        }
        return this.time - obj.time;
    }
    
} 
public class Main {

    public static int solution(String[][] book_time) {
        int answer = 0;

        List<Room> list = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
            int sTime = Integer.parseInt(book_time[i][0].replace(":", ""));
            int eTime = Integer.parseInt(book_time[i][1].replace(":", ""));
            int cleanTime = eTime + 10;
            int min = cleanTime % 100;
            if (min >= 60) {
                cleanTime = cleanTime + 100 - 60;
                if (cleanTime >= 2500) {
                    cleanTime = 0;
                }
            }
            list.add(new Room(sTime, 's'));
            list.add(new Room(cleanTime, 'e'));
        }

        Collections.sort(list);

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
                                            book_time                                                             result
            [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]	3
            [["09:10", "10:10"], ["10:20", "12:20"]]                                                            	1
            [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]	                                        3
         */
        String[][] arr = {
                {"09:10", "09:10"}, {"09:10", "10:10"}, {"09:10", "10:10"}
        };

        System.out.println(solution(arr));
    }
}