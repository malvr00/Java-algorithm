public class Main {

    /**
     * Level3.
     * 단어 변환
     * DFS, BFS
     */

    private static boolean[] ch;
    private static int answer = Integer.MAX_VALUE;
    private void dfs(String begin, String target, String[] words, int cnt) {
        if(begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(ch[i]) continue;
            int eqCnt = 0;
            for (int j = 0; j < begin.length(); j++) {
                char c = begin.charAt(j);
                char wC = words[i].charAt(j);
                if(c == wC) eqCnt++;
            }
            if (begin.length() - 1 == eqCnt) {
                ch[i] = true;
                dfs(words[i], target, words, cnt + 1);
                ch[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        ch = new boolean[words.length];

        dfs(begin, target, words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}