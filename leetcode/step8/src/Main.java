public class Main {

    /**
     * Container With Most Water
     * Two Point
     */

    public int maxArea(int[] height) {
        int answer = 0;

        int lt = 0, rt = height.length - 1;

        while (lt < rt) {
            answer = Math.max(answer, Math.min(height[lt], height[rt]) * (rt - lt));

            if (height[lt] < height[rt]) {
                lt++;
            } else {
                rt++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new Main().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}