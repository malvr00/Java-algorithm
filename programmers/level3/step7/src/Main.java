import java.util.*;

public class Main {

    /**
     * Level 3
     * 인사고과
     * Greedy
     */
    static public class Score implements Comparable<Score> {
        int aPoint;
        int bPoint;
        int sum;
        int idx;

        public Score(int aPoint, int bPoint, int idx) {
            this.aPoint = aPoint;
            this.bPoint = bPoint;
            this.sum = aPoint + bPoint;
            this.idx = idx;
        }

        @Override
        public int compareTo(Score obj) {
            if (obj.aPoint == this.aPoint) {
                return obj.bPoint - this.bPoint;
            }
            return obj.aPoint - this.aPoint;
        }
    }

    static public class SumScore implements Comparable<SumScore> {
        int sum;
        int idx;

        public SumScore(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }

        @Override
        public int compareTo(SumScore obj) {
            if (obj.sum == this.sum) {
                return this.idx - obj.idx;
            }
            return obj.sum - this.sum;
        }
    }

    public int solution(int[][] scores) {
        if(scores.length == 1) return 1;

        List<Score> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Score(scores[i][0], scores[i][1], i));
        }

        Collections.sort(list);
        List<SumScore> sumList = new ArrayList<>();
        int aMax = list.get(0).aPoint;
        int bMax = list.get(0).bPoint;
        sumList.add(new SumScore(list.get(0).sum, list.get(0).idx));

        int idx = 1;
        for (; idx < list.size(); idx++) {
            Score score = list.get(idx);
            if(score.aPoint == aMax) {
                sumList.add(new SumScore(score.sum, score.idx));
            } else {
                break;
            }
        }

        int tempMax = bMax;
        for (; idx < list.size(); idx++) {
            boolean flag = false;
            Score score = list.get(idx);
            if (score.aPoint != list.get(idx - 1).aPoint) {
                bMax = Math.max(bMax, tempMax);
            }
            tempMax = Math.max(tempMax, score.bPoint);
            if (bMax > score.bPoint) {
                if(score.idx == 0) return -1;
                flag = true;
            }
            if(flag) continue;
            sumList.add(new SumScore(score.sum, score.idx));
        }

        Collections.sort(sumList);

        int cnt = 1;
        if(sumList.get(0).idx == 0) return cnt;
        int point = sumList.get(0).sum;
        for (int i = 1; i < sumList.size(); i++) {
            cnt++;
            if (sumList.get(i).sum < point) {
                point = sumList.get(i).sum;
                if(sumList.get(i).idx == 0) return cnt;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};
        System.out.println(T.solution(scores));
    }
}