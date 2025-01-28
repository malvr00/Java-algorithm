import java.util.*;

public class Main {

    /**
     * Min Stack
     */

    static public class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            stack.add(val);
            if(minStack.isEmpty() || minStack.peek() >= val) {
                minStack.add(val);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if(pop == minStack.peek()) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
         obj.push(10);
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin();
    }
}