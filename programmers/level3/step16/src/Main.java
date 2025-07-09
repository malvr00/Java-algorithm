import java.util.*;

public class Main {

    /**
     * Level3.
     * 다단계 칫솔 판매 (2021 Dev-Matching)
     * 재귀호출
     */

    private final Map<String, Integer> priceMap = new HashMap<>();

    public void mount(String node, int amount, Map<String, String> root) {
        int price = amount / 10;

        // 현재 node 순 수익
        priceMap.put(node, priceMap.getOrDefault(node, 0) + (amount - price));

        if (price > 0) {
            mount(root.get(node), price, root);
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, String> node = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            // key => 자식, value => 부모
            node.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < seller.length; i++) {
            // 100 == 연필 평균 단가
            mount(seller[i], amount[i] * 100, node);
        }

        int i = 0;
        for (String s : enroll) {
            answer[i++] = priceMap.getOrDefault(s, 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main m = new Main();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(m.solution(enroll, referral, seller, amount)));

    }
}