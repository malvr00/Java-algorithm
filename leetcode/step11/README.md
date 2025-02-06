# [Find All Numbers Disappeared in an Array](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step11/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)) <br/>
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

## 해법
* 맨 처음 `nums`의 원소들을 `set`에 저장한다.
* `nums.length` 만큼 반복문을 돌면서 `set`에 없는 원소를 정답 배열에 저장 후 반환한다.

## 핵심
* `nums` 원소를 저장 후 `1 ~ nums.length` 범위 안에 존재하지 않는 원소를 빠르게 찾아야한다.

## 문제점
* 문제지문 파악하기가 어려웠다. 천천히 퍼즐 맞추듯이 문제를 풀어야겠다.