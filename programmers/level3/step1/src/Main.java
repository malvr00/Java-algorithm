import java.util.*;

class Solution {

    /**
     *  Level3.
     *  문제: 주사위 고르기
     *        2024 KAKAO WINTER INTERNSHIP
     *  주사위의 조합: nCr, 주사위 승패: 이진 탐색
     */

    int DICE_CNT = 0;
    final int DICE_BASE = 6;

    int[] dSelect;
    int aWinCnt = 0;
    int saveWinCnt = 0;
    List<Integer> answerList;

    // 승패 계산
    public int winScore(int basePoint, List<Integer> bDice) {
        int result = 0;
        int lt = 0, rt = bDice.size() - 1;

        while(lt <= rt) {
            int mid = (lt + rt) / 2;
            int bScore = bDice.get(mid);

            if(basePoint > bScore) {
                result = result + 1 + (mid - lt);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        return result;
    }

    // 주사위 승패
    public void game(List<Integer> aDice, List<Integer> bDice) {
        final int chooseSize = aDice.size();

        Collections.sort(bDice);

        for(int i = 0; i < chooseSize; i++) {
            final int aVal = aDice.get(i);
            aWinCnt += winScore(aVal, bDice);
        }
    }

    // 선택된 주사위의 합
    public void sumCombi(int L, int sum, int[] userDice, int[][] dice, List<Integer> sumList) {
        if(L == DICE_CNT / 2) {
            sumList.add(sum);
        } else {
            for(int i = 0; i < DICE_BASE; i++) {
                sumCombi(L + 1, sum + dice[userDice[L]][i], userDice, dice, sumList);
            }
        }
    }

    // 주사위 A, B 유저의 주사위 선택
    public void select(int[][] dice) {
        aWinCnt = 0;

        int[] aDice = new int[DICE_CNT / 2];
        int[] bDice = new int[DICE_CNT / 2];

        List<Integer> aDiceSumList = new ArrayList<>();
        List<Integer> bDiceSumList = new ArrayList<>();

        // 선택된 주사위 분배
        int aDiceSize = 0, bDiceSize = 0;
        for(int i = 0; i < DICE_CNT; i++) {
            if(dSelect[i] == 1) {
                aDice[aDiceSize++] = i;
            } else {
                bDice[bDiceSize++] = i;
            }
        }

        // A 주사위 합
        sumCombi(0, 0, aDice, dice, aDiceSumList);
        // B 주사위 합
        sumCombi(0, 0, bDice, dice, bDiceSumList);

        game(aDiceSumList, bDiceSumList);
    }

    // 주사위 조합
    public void combi(int L, int s, int[][] dice) {
        if(L == DICE_CNT / 2) {
            select(dice);
            int tempWinCnt = aWinCnt;
            if(saveWinCnt < aWinCnt) {
                saveWinCnt = aWinCnt;
                answerList = new ArrayList<>();
                for(int i = 0; i < DICE_CNT; i++){
                    if(dSelect[i] == 1) {
                        answerList.add(i + 1);
                    }
                }
            }
        } else {
            for(int i = s; i < DICE_CNT; i++) {
                dSelect[i] = 1;
                combi(L + 1, i + 1, dice);
                dSelect[i] = 0;
            }
        }
    }

    public int[] solution(int[][] dice) {
        int[] answer = {0};

        DICE_CNT = dice.length;
        dSelect = new int[DICE_CNT];

        combi(0, 0, dice);

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();

//        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}})));

//        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}})));

        System.out.println(Arrays.toString(T.solution(new int[][]{{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}})));
    }
}