import java.util.Scanner;

public class Main {
    public int solution (String str, char t){
        int result = 0;
        for(int i = 0; i < str.length(); i++){
            char temp = str.toUpperCase().charAt(i);
            if (temp == t) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main c = new Main();

        Scanner scan1 = new Scanner(System.in);

        String strValue = scan1.nextLine();
        String strFindParam = scan1.nextLine();

        int nEq = c.solution(strValue, strFindParam.toUpperCase().charAt(0));
        System.out.println(nEq);
    }
}