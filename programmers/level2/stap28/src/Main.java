import java.util.Objects;

public class Main {

    /**
     * Level2.
     * 이진 변환 반복하기
     */
    public int[] solution(String s) {

        int lv = 0;
        int cnt = 0;
        while (!Objects.equals(s, "1")) {
            lv++;
            for (char x : s.toCharArray()) {
                if (x == '0') {
                    cnt++;
                }
            }

            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
        }

        return new int[]{lv, cnt};
    }

    public static void main(String[] args) {
        /*
            s	            result
            "110010101001"	[3,8]
            "01110"	        [3,3]
            "1111111"	    [4,1]
         */
        String s = "110010101001";
        Main main = new Main();
        int[] solution = main.solution(s);
        for (int x : solution) {
            System.out.print(x + " ");
        }
    }
}