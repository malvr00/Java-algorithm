# [Min Stack](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step4/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/min-stack/description/)) <br/>
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.<br/>
Implement the MinStack class:<br/>
<br/>
1. MinStack() initializes the stack object.<br/>
2. void push(int val) pushes the element val onto the stack.<br/> 
3. void pop() removes the element on the top of the stack.<br/>
4. int top() gets the top element of the stack.<br/>
5. int getMin() retrieves the minimum element in the stack.<br/>
6. You must implement a solution with O(1) time complexity for each function.

## 해법
* 최소 값을 저장하는 `Stack`, 전체를 저장하는 `Stack`을 가지고 문제를 해결한다.

## 핵심
* 문제의 핵심은 `O(1)`로 해결해야 하기 때문에 `Stack`을 2 개 만들어서 관리하면 쉽게 풀 수 있다.

## 참고
* 문제에서 `Stack`을 구현하라고 했지만 직접 구현보다 이미 제공해주는 `Stack`자료형을 활용해서 문제를 풀어야한다.