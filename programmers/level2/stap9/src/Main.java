import java.util.*;

public class Main {

    static int[] saleCh2;
    static int[] answer = new int[2];

    public static void DFS(int[][] users, int[] emoticons, int lv) {
        if(lv == emoticons.length) {
            int newRegi = 0;
            int price = 0;
            for (int i = 0; i < users.length; i++) {
                int sum = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    int num = saleCh2[j] * 10;
                    if (num >= users[i][0]) {
                        sum += emoticons[j] - (emoticons[j] * num / 100);
                    }
                }
                if (sum >= users[i][1]) {
                    newRegi++;
                } else {
                    price += sum;
                }
            }
            if (answer[0] < newRegi) {
                answer[0] = newRegi;
                answer[1] = price;
            } else if (answer[0] == newRegi) {
                answer[1] = Math.max(answer[1], price);
            }

        } else {
            for (int i = 4; i > 0; i--) {
                saleCh2[lv] = i;
                DFS(users, emoticons, lv + 1);
                saleCh2[lv] = 0;
            }
        }
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        saleCh2 = new int[emoticons.length];

        DFS(users, emoticons, 0);

        return answer;
    }

    public static void main(String[] args) {
        /*  users                                                       emoticons                   result
            [[40, 10000], [25, 10000]]	                                [7000, 9000]	            [1, 5400]
            [[40, 2900], [23, 10000], [11, 5200], [5, 5900],
            [40, 3100], [27, 9200], [32, 6900]]	                        [1300, 1500, 1600, 4900]	[4, 13860]
         */
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        int[] solution = solution(users, emoticons);

        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}