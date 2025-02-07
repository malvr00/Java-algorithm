# [Valid Palindrome II](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step12/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/valid-palindrome-ii/description/)) <br/>
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

## 해법
* `s` 의 문자열 처음과 끝을 차례로 비교한다.
* 문자열을 전체를 확인하는데, 1 차로는 양 끝이 같을 때 까지만 비교한다.
* `시작 포인트`가 `종료 포인트`보다 크면 `TRUE`를 반환한다.
  * `시작 포인트`가 더 큰 경우는 펠리드롬일 경우 밖에 없다.
* 마지막으로 양 끝이 다를 경우가 있는데 이때는 서로 다른 문자열의 시작, 종료 시점을 가지고 시작 지점을 `1 증가`후 팰린드롬 비교, 종료 시점을 `1 감소` 후 팰린드롬을 비교 후 하나라도 팰린드롬의 경우가 되면 `TRUE`를 반환한다.

## 핵심
* 처음과 끝을 차례로 비교해서 `O(n)`으로 탐색하는게 핵심이다.

## 문제점
* 맨 처음 시도했을 때는 `시작 포인트`를 증가 하고 `종료 포인트`의 문자열과 같으면 `시작 포인트` 증가 이런식으로 팰린드롬을 찾았는데, 이렇게 될 경우 `종료 포인트`를 먼저 감소 시킨 후 팰린드롬이 되는 경우가 있다.
  * 문제를 해결할 때 한 방향만 생각하지말고 움직일 수 있는 경우가 2 가지 이상일 경우는 해당 가지 수 모두를 탐색해서 문제를 해결하는 습관을 들이자.