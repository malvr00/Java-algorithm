public class Main {

    /**
     * Level2.
     * k 진수에 소수 개수 구하기
     */
    public int solution(int n, int k) {
        int answer = 0;

        String sBinary = Integer.toString(n, k);

        String sVal = "";
        for (int i = 0; i < sBinary.length(); i++) {
            char x = sBinary.charAt(i);

            if (x == '0') {
                if (!sVal.equals("")) {
                    long val = Long.parseLong(sVal, 10);

                    if (check(val)) {
                        answer++;
                    }
                    sVal = "0";
                } else {
                    sVal += x;
                }
            } else {
                sVal += x;
            }

        }

        if (!sVal.equals("")) {
            if (check(Long.parseLong(sVal, 10))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean check(long val) {
        if (val <= 1) {
            return false;
        }

        long sqrt = (long) Math.sqrt(val);

        for( int i = 2; i <= sqrt; i++) {

            if(val % i == 0) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        /*
            n	    k	    result
            437674	3	    3
            110011	10	    2
         */

        int n = 5;
        int k = 10;
        Main main = new Main();
        int solution = main.solution(n, k);
        System.out.println(solution);
    }
}