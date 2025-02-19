# [Valid Anagram](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step16/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/valid-anagram/description/)) <br/>
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

## 해법
* 주어지는 문자열 `s`와 `t`를 각각 `Map`에 문자를 카운팅하면서 저장한다.
* `s` 문자가 저장된 `Map`, `t` 문자가 저장된 `Map` 두 개를 비교해서 `Null || sCount != tCount` 일 경우 `FALSE`를 반환한다. 

## 핵심
* `s` 문자열과 `t` 문자열이 같으면 되기 때문에 각 문자를 카운트 후 비교하는게 핵심이다.

## 참고
* `Map`을 활용하지 않고 각 문자열들을 정렬 후 Two Point로 비교해도 쉽게 정답이 나올 것 같다.
