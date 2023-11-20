import java.util.*;

public class Main {

    public int solution(int[] topping) {
        int answer = 0;
        int lt1 = 0, rt1 = 0;
        int lt2 = 1, rt2 = topping.length - 1;
        HashMap<Integer, Integer> bro1 = toppingSet(lt1, rt1, topping);
        HashMap<Integer, Integer> bro2 = toppingSet(lt2, rt2, topping);

        for (int i = 1; i < topping.length; i++) {
            if (bro1.size() == bro2.size()) {
                answer++;
            }
            bro1.put(topping[i], bro1.getOrDefault(topping[i], 0) + 1);
            bro2.put(topping[i], bro2.get(topping[i]) - 1);
            if (bro2.get(topping[i]) == 0) {
                bro2.remove(topping[i]);
            }
        }

        return answer;
    }

    public static HashMap<Integer, Integer> toppingSet(int lt, int rt, int[] topping) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = lt; i <= rt; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        /*
            topping	                    result
            [1, 2, 1, 3, 1, 4, 1, 2]	2
            [1, 2, 3, 1, 4]	            0
         */
        Main main = new Main();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(main.solution(topping));
    }
}