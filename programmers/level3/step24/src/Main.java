public class Main {

    /**
     * Level3.
     * 징검다리 건너기 (KAKAO 인턴)
     * 이분탐색
     */

    public boolean check(int[] stones, int k, int people) {
        int skip = 0;
        for (int stone : stones) {
            if (stone - people < 0) {
                skip++;
                // 'k' 인원 만큼 발판을 모두 밟을 수 있어야 마지막까지 도달 가능
                if (skip >= k) return false;
            } else {
                skip = 0;
            }
        }

        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        // 내구도 최소 ~ 최대
        int left = 1, right = 200_000_000;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (check(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 5, 2};
        int k = 3;

        System.out.println(m.solution(stones, k));
    }
}