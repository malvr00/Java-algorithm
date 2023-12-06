import java.util.*;

public class Main {

    /**
     * Level2
     * 튜플 ( KAKAO )
     */
    public int[] solution(String s) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        String[] arr = s.split("}");

        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>());
            String str = arr[i].replaceAll("\\{", "");

            String[] strArr = str.charAt(0) == ','
                    ? str.replaceFirst("\\,", "").split(",")
                    : str.split(",");

            for (String x : strArr) {
                list.get(i).add(Integer.parseInt(x));
            }
        }

        Collections.sort(list, Comparator.comparingInt(ArrayList::size));

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                boolean flag = false;
                for (int v = 0; v < list.get(i).size(); v++) {
                    if (answer[v] == list.get(i).get(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    answer[i] = list.get(i).get(j);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
        s	                                result
        "{{2},{2,1},{2,1,3},{2,1,3,4}}"	    [2, 1, 3, 4]
        "{{1,2,3},{2,1},{1,2,4,3},{2}}"	    [2, 1, 3, 4]
        "{{20,111},{111}}"	                [111, 20]
        "{{123}}"	                        [123]
        "{{4,2,3},{3},{2,3,4,1},{2,3}}"	    [3, 2, 4, 1]
         */
        String s = "{{20,111},{111}}";
        Main main = new Main();
        int[] solution = main.solution(s);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}