import java.util.*;

public class Main {
    /*
        3. 크레인 인형뽑기 (카카오)
     */

    public static int solution(int board, int[][] arr1, int moves, int[] arr2) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < moves; i++) {
            int movesVal = arr2[i] - 1;
            for (int j = board - 1; j >= 0; j--) {
                int nextItem = arr1[j][movesVal];
                if (nextItem != 0) {
                    arr1[j][movesVal] = 0;
                    if (!basket.isEmpty()) {
                        int basketTop = basket.peek();
                        if (basketTop == nextItem) {
                            basket.pop();
                            answer++;
                            break;
                        }
                    }
                    basket.push(nextItem);

                    break;
                }
            }
        }

        return answer * 2;
    }

    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int tmp = board[i][pos - 1];
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int board = kb.nextInt();
        int[][] arr1 = new int[board][board];

        for (int i = board - 1; i >= 0; i--) {
            for (int j = 0; j < board; j++) {
                arr1[i][j] = kb.nextInt();
            }
        }
        int moves = kb.nextInt();
        int[] arr2 = new int[moves];
        for (int i = 0; i < moves; i++) {
            arr2[i] = kb.nextInt();
        }

        System.out.println(solution(board, arr1, moves, arr2));
    }
}