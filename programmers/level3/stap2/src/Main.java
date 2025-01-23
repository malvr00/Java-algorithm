import java.util.*;

class Solution {

    /**
     * 프로그래머스 레벨 3
     * 문제: n + 1 카드게임
     *       2024 KAKAO WINTER INTERNSHIP
     * 구현문제 + Greedy
     *   (코인을 사용할지, 코인을 사용안할지, 내 손패에서 카드를 낼지, 카드뭉치와 함께 카드를 낼지) 최선의 선택을 해야 함
     */
    public int solution(int coin, int[] cards) {
        int answer = 0;

        int target = cards.length + 1;

        final int FIRST_GET = 3;
        final int CARD_SIZE = cards.length - 1;

        // 문제 지문에 원소 중복이 되지 않는다고 나와있기 때문에 List대신 Set을 채택
        Set<Integer> myCards = new HashSet<>();
        Set<Integer> nowCards = new HashSet<>();

        // 최초 카드 선택
        int idx = 0;
        for(; idx <= CARD_SIZE / FIRST_GET; idx++) {
            myCards.add(cards[idx]);
        }

        // 라운드 진행
        while(idx <= cards.length) {
            answer++;
            // 카드 뭉치 모두 소진
            if(idx == cards.length) return answer;

            boolean flag = false;
            nowCards.add(cards[idx++]);
            nowCards.add(cards[idx++]);

            // 뽑은 카드 중 손 패에 있는 카드와 비교 ( 코인 확인 )
            if(coin > 0) {
                for(Integer card : nowCards) {
                    if(myCards.contains(target - card)) {
                        coin--;
                        flag = true;
                        nowCards.remove(card);
                        myCards.remove(target - card);
                        break;
                    }
                }
            }

            // 뽑은 카드로도 해결 할 수 없을 때 내 손 패 확인
            if(!flag) {
                for(Integer card : myCards) {
                    if(myCards.contains(target - card)) {
                        flag = true;
                        myCards.remove(card);
                        break;
                    }
                }
            }

            // 손 패로도 해결 할 수 없을 때 코인으로 교환 가능한 카드들 확인 ( 코인 확인 )
            if(!flag) {
                if(coin > 1) {
                    for(Integer card : nowCards) {
                        if(nowCards.contains(target - card)) {
                            coin -= 2;
                            flag = true;
                            nowCards.remove(card);
                            nowCards.remove(target - card);
                            break;
                        }
                    }
                }
            }

            // 버릴 패 없음
            if(!flag) return answer;
        }

        return answer;
    }

    static public void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(4,	new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));
//        T.solution(3,	new int[]{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12});
//        T.solution(2,	new int[]{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7});
//        T.solution(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18});
    }
}