# [Valid Parentheses](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step3/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/valid-parentheses/)) <br/>
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.<br/>
An input string is valid if:<br/>
1. Open brackets must be closed by the same type of brackets.<br/>
2. Open brackets must be closed in the correct order.<br/>
3. Every close bracket has a corresponding open bracket of the same type.

## 해법
* 주어진 값 `s`만큼 반복문을 돌때 `여는 괄호`가 나오면 스택에 괄호 값을 저장한다.
* `닫는 괄호`가 나왔을 때 스택에서 맨 위에 값을 빼내어 해당 `닫는 괄호`와 맞는지 확인하고 맞지 않다면 `FALSE`를 반환한다.
* 마지막까지 스택에 값이 있을 경우 `FALSE`를 반환 그렇지 않다면 `TRUE`

## 핵심
* 괄호의 값을 스택에 넣어서 적절히 비교하여 정답을 도출하는게 중요하다.

## 문제
* 현재 푼 로직 가독성이 너무 안좋아서 현재 방식이 아닌 `여는 괄호`가 나왔을 때 해당 `닫는 괄호`를 스택에 넣고 `s.charAt(i)`의 값이 `닫는 괄호`일 경우 스택 맨 윗 값과 비교해서 맞지 않으면 `FLASE`로 반환하는 방식도 좋을 것 같다. 