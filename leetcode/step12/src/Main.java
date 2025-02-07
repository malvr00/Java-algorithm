public class Main {

    /**
     * Valid Palindrome II
     */

    private boolean pal(String s, int lt, int rt) {
        while(lt < rt) {
            if(s.charAt(lt) != s.charAt(rt)) return false;
            lt++;
            rt--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int lt = 0, rt = s.length() - 1;

        while(lt < rt && s.charAt(lt) == s.charAt(rt)) {
            lt++;
            rt--;
        }

        if(lt >= rt) return true;

        return pal(s, lt + 1, rt) || pal(s, lt, rt - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Main().validPalindrome("abcd"));
    }
}