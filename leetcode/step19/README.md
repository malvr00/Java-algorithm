# [Minimum Size Subarray Sum](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step19/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/minimum-size-subarray-sum/description/)) <br/>
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

## 해법
* 슬라이드 윈도우 방법으로 누적합으로 문제를 해결해야한다.
* 누적합을 진행하면서 `target` 값 보다 크거나 같을경우 정답변수에 더 작은 길이 값`(i - start + 1)`을 배교해 저장한다.

## 핵심
* 문제는 단순한데 지문해석을 잘못하면 문제를 풀 수 없다. `greater than or equal = 크거나 같을때` 

## 문제점
