# [Contains Duplicate](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step9/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/contains-duplicate/description/)) <br/>
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

## 해법
* `nums` 원소 값을 `map`에 카운팅하면서 저장한다.
* `map`의 `value`가 1 보다 클 경우 `TRUE` 반환한다.
* 마지막까지 `TRUE` 반환이 안된다면, `FALSE` 반환

## 핵심
* `nums` 중복 원소 값을 찾는게 핵심이다.

## 문제점
