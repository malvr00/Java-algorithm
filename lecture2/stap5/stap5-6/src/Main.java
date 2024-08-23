import java.util.*;

public class Main {

    public class Booking implements Comparable<Booking> {
        int idx;
        int s;
        int e;

        public Booking(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Booking obj) {
            return this.e - obj.e;
        }
    }

    public class Train implements Comparable<Train> {
        int idx;
        int s;
        int e;
        int maxCnt;
        LinkedList<Booking> nowCnt = new LinkedList<>();

        public Train(int idx, int s, int e, int maxCnt) {
            this.idx = idx;
            this.s = s;
            this.e = e;
            this.maxCnt = maxCnt;
        }

        @Override
        public int compareTo(Train o) {
            return this.e - o.e;
        }
    }


    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;

        int[] train = new int[n + 1];
        List<List<Booking>> listBookings = new ArrayList<>();

        for (int[] tran : trans) {
            train[tran[0]] += tran[2];
            train[tran[1]] -= tran[2];
        }
        for (int i = 1; i <= n; i++) {
            train[i] = train[i] + train[i - 1];
        }
        for (int i = 0; i <= n; i++) {
            listBookings.add(new ArrayList<>());
        }
        for (int i = 0; i < bookings.length; i++) {
            listBookings.get(bookings[i][0]).add(new Booking(i, bookings[i][0], bookings[i][1]));
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int station = 1; station <= n; station++) {
            List<Booking> passengers = listBookings.get(station);
            Collections.sort(passengers);

            while (!list.isEmpty() && list.peekFirst() == station) {
                answer++;
                list.poll();
            }

            for (Booking passenger : passengers) {
                list.add(passenger.e);
            }
            list.sort((a, b) -> a - b);

            while (list.size() > train[station]) {
                list.pollLast();
            }
        }

        return answer;
    }

    public int solution(int n, int[][] trans, int[][] bookings, int version){
        int answer=0;
        int[] sum = new int[n+1];
        for(int[] x : trans){
            sum[x[0]] += x[2];
            sum[x[1]] -= x[2];
        }
        for(int i = 1; i <= n; i++){
            sum[i] += sum[i-1];
        }
        int bN = bookings.length;
        Arrays.sort(bookings, (a, b) -> a[0] - b[0]);
        LinkedList<Integer> nums = new LinkedList<>();
        int ix = 0;
        for(int i = 1; i <= n; i++){
            while(!nums.isEmpty() && nums.peek() == i){
                answer++;
                nums.pollFirst();
            }
            while(ix < bN && bookings[ix][0] == i){
                nums.add(bookings[ix][1]);
                ix++;
            }
            Collections.sort(nums);
            while(nums.size() > sum[i]){
                nums.pollLast();
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}