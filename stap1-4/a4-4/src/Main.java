import java.util.*;

public class Main {
    /*
        4. 모든 아나그램 찾기(Hash, sliding window : 시간복잡도 O(n))
     */

    public static int solution(String s, String t) {
        // ID 5번 오답 two pointers 문제 인듯 함
        int answer = 0;
        HashMap<Character, Integer> mapT = new HashMap<>();
        int startIndex, count = 0;

        for (char tmp : t.toCharArray()) {
            mapT.put(tmp, mapT.getOrDefault(tmp, 0) + 1);
        }

        int lt = 0;
        for (startIndex = 0; startIndex < s.length(); startIndex++) {
            char val = s.charAt(startIndex);

            if (!mapT.containsKey(val)) {
                while (count > 0) {
                    mapT.put(s.charAt(lt), mapT.get(s.charAt(lt)) + 1);
                    count--;
                    lt++;
                }
                lt++;
                continue;
            }

            mapT.put(val, mapT.get(val) - 1);
            if (mapT.get(val) < 0) {
                mapT.put(s.charAt(lt), mapT.get(s.charAt(lt)) + 1);
                lt++;
                continue;
            }
            count++;
            if (count == t.length()) {
                mapT.put(s.charAt(lt), mapT.get(s.charAt(lt)) + 1);
                count--;
                answer++;
                lt++;
            }
        }

        return answer;
    }

    public static int solution2(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (char x : t.toCharArray()) {
            mapT.put(x, mapT.getOrDefault(x, 0) + 1);
        }

        int l = t.length() - 1;
        for (int i = 0; i < l; i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt = l; rt < s.length(); rt++) {
            mapS.put(s.charAt(rt), mapS.getOrDefault(s.charAt(rt), 0) + 1);
            if (mapS.equals(mapT)) {
                answer++;
            }
            mapS.put(s.charAt(lt), mapS.get(s.charAt(lt)) - 1);

            if (mapS.get(s.charAt(lt)) == 0) {
                mapS.remove(s.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        String s = kb.nextLine();
        String t = kb.nextLine();

        System.out.println(solution2(s, t));
    }
}