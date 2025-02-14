import java.util.*;

public class Main {

    /**
     * Isomorphic Strings
     */

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!Objects.equals(sMap.get(s.charAt(i)), tMap.get(t.charAt(i)))) return false;

            sMap.put(s.charAt(i), i);
            tMap.put(t.charAt(i), i);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Main().isIsomorphic("abcd", "qwer"));
    }
}