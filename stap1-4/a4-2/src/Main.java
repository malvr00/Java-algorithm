import java.util.*;

public class Main {
    /*
        2. 아나그램(HashMap)
     */

    public static String solution(String s1, String s2) {
        String answer = "YES";

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char tmp : s1.toCharArray()) {
            map1.put(tmp, map1.getOrDefault(tmp, 0) + 1);
        }
        for (char tmp : s2.toCharArray()) {
            map2.put(tmp, map2.getOrDefault(tmp, 0) + 1);
        }

        if (map1.size() != map2.size()) {
            answer = "NO";
        } else {
            for (char tmp : map1.keySet()) {
                if (map1.get(tmp) != map2.get(tmp)) {
                    answer = "NO";
                    break;
                }
            }
        }

        return answer;
    }

    public static String solution2(String s1, String s2) {
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                answer = "NO";
                break;
            } else {
                map.put(x, map.get(x) - 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String str1 = kb.nextLine();
        String str2 = kb.nextLine();

        System.out.println(solution(str1, str2));
    }
}