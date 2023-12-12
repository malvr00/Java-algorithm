import java.util.*;

public class Main {

    /**
     * Level2.
     * 큰 수 만들기
     */
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder answerBuilder = new StringBuilder();

        char[] array = number.toCharArray();

        int len = array.length - k;

        int start = 0;

        for(int i =0; i<len; i++){
            char max = '0';
            int secLen = i + k;
            for(int j = start; j <= secLen; j++){
                if(array[j] > max){
                    max = array[j];
                    start=j+1;
                }
            }
            answerBuilder.append(max);
        }

        answer = answerBuilder.toString();
        return answer;
    }

    public static void main(String[] args) {

        /*
            number	        k	return
            "1924"	        2	"94"
            "1231234"	    3	"3234"
            "4177252841"	4	"775841"
         */
        String number = "1231234";
        int k = 3;
        Main main = new Main();
        String solution = main.solution(number, k);
        System.out.println(solution);
    }
}