import java.util.*;

public class Main {

    /**
     * 강의.
     * 비밀번호 ( 시뮬레이션 & 구현 )
     */
    public int[] getNumber(int val, int[][] keypadArr) {
        // 시작 좌표 찾는 메소드
        int[] arr = {-1, -1};

        for (int x = 0; x < keypadArr.length; x++) {
            for (int y = 0; y < keypadArr.length; y++) {
                if (keypadArr[x][y] == val) {
                    return new int[]{x, y};
                }
            }
        }
        return arr;
    }
    public int solution(int[] keypad, String password){
        /*
            내 풀이
         */
        int answer = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] keypadArr = new int[3][3];

        // 키 패드 생성
        int row = 0;
        for (int i = 0; i < keypad.length; i++) {
            if (i != 0 && i % 3 == 0) {
                row++;
            }

            keypadArr[row][i % 3] = keypad[i];
        }
        
        // 비밀번호 누르기
        for (int i = 1; i < password.length(); i++) {
            int preVal = Character.getNumericValue(password.charAt(i - 1));
            int postVal = Character.getNumericValue(password.charAt(i));

            if(preVal == postVal) continue;

            int[] point = getNumber(preVal, keypadArr);

            boolean flag = false;
            for (int j = 0; j < dx.length; j++) {
                int nx = point[0] + dx[j];
                int ny = point[1] + dy[j];

                if (nx >= 0 && nx <= row && ny >= 0 && ny <= row && keypadArr[nx][ny] == postVal) {
                    answer += 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer += 2;
            }
        }

        return answer;
    }

    public int solution(int[] keypad, String password, int version){
        /*
            강의
         */
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }
        // 전부 범위안에 없다는 가정으로 2로 세팅
        for(int i = 0; i < 10; i++){
            Arrays.fill(dist[i], 2);
        }

        // 자기 자신 0 으로 초기화
        for(int i = 0; i < 10; i++) dist[i][i] = 0;

        // 자신을 기준으로 키패드에서 8 방향으로 검색 후 1 세팅
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        for(int i = 1; i < password.length(); i++){
            int from = (int)password.charAt(i-1)-48;
            int to = (int)password.charAt(i)-48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args){
        Main T = new Main();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218", 2));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}