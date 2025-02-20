import java.util.*;

public class Main {

    /**
     * Find All Anagrams in a String
     */

    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();

        List<Integer> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();


        for(int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int lt = 0, rt = 0;
        for(; rt < p.length() - 1; rt++) {
            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
        }

        for(; rt < s.length(); rt++) {
            sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
            boolean flag = false;

            for(Character c : sMap.keySet()) {
                Integer cnt = map.get(c);
                if(cnt == null) {
                    flag = false;
                    break;
                }
                if(!Objects.equals(cnt, sMap.get(c))) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }

            if(flag) answer.add(lt);
            sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
            if(sMap.get(s.charAt(lt)) <= 0) sMap.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().findAnagrams("asdcasc", "asd"));
    }
}