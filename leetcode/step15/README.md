# [Two Sum II - Input Array Is Sorted](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step15/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)) <br/>
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.<br/>
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.<br/>
The tests are generated such that there is exactly one solution. You may not use the same element twice.<br/>
Your solution must use only constant extra space.

## 해법
* `numbers`배열을 탐색하면서 `target`이 되는 인덱스를 찾는문제 이므로 Two Point 알고리즘을 택한 후 문제를 해결한다.
* `numbers[i] + numbers[j]` 가 `target`보다 큰 경우 `j`를 증가 그렇지 않고 작다면 `i`를 증가 `target` 값과 같다면 정답을 도출한다.

## 핵심
* 왼쪽과 오른쪽 포인트를 어떻게 이동시킬지가 핵심이다.

## 문제점
