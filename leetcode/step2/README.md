# [First Unique Character in a String](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step2/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/first-unique-character-in-a-string/description/)) <br/>
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

## 해법
* 주어진 값 `s` 값을 `Character`로 쪼개서 `Map`에 저장한다.
  * `Map`에 저장할 때 `Character`의 원소를 카운팅해서 넣는다. 1 개라면 '1' 2 개라면 '2'

## 핵심
* `Map`에 저장된 카운팅 값을 가지고 `s`를 한번 더 탐색한 후 값이 `1`일 경우 반환한다.

## 문제
