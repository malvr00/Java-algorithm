import java.util.*;

public class Main {

    /**
     *  Valid Anagram
     */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(Character key : sMap.keySet()) {
            if(tMap.get(key) == null) return false;
            if(!Objects.equals(tMap.get(key), sMap.get(key))) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main().isAnagram("abs", "abs"));
    }
}