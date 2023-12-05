import java.util.*;

public class Main {

    static List<String> arr = new ArrayList<>();
    public void dfs(int lv, int course, String[] orders, StringBuilder strSum, int i, int j) {
        if (lv == course) {
            System.out.println(strSum.toString());
            int total = 0;
                for (int s = 0; s < orders.length; s++) {
                    int cnt = 0;
                    for (int idx = 0; idx < course; idx++) {
                        for (char x : orders[s].toCharArray()) {
                            if (strSum.charAt(idx) == x) {
                                cnt++;
                                break;
                            }
                        }
                    }
                    if (cnt == course) {
                        total++;
                    }
            }
            System.out.println(total);
        } else {
            for (int ii = i; ii < orders.length; ii++) {
                if (orders[ii].length() < course) {
                    dfs(lv, course, orders, strSum, i + 1, j);
                }
                for (int jj = j; jj < orders[ii].length(); jj++) {
                    dfs(lv + 1, course, orders, strSum.append(orders[ii].charAt(j)), i, j + 1);
                    strSum.deleteCharAt(strSum.length() - 1);
                }
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < course.length; i++) {
            dfs(0, course[i], orders, new StringBuilder(), 0, 0);
        }

        return answer;
    }

    public static void main(String[] args) {

        /*
            orders	                                            course	    result
            ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	    [2,3,4]	    ["AC", "ACDE", "BCFG", "CDE"]
            ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	    ["ACD", "AD", "ADE", "CD", "XYZ"]
            ["XYZ", "XWY", "WXA"]	                            [2,3,4]	    ["WX", "XY"]
         */
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        Main main = new Main();
        String[] solution = main.solution(orders, course);
        for (String s : solution) {
            System.out.print(s + " ");
        }

    }
}