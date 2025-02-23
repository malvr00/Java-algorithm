# [Set Matrix Zeroes](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step20/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/set-matrix-zeroes/description/)) <br/>
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.<br/>
You must do it in place.

## 해법
* 맨 처음 `matrix` 원소 값 중 `0` 인 값의 좌표를 배열에 저장한다.
* 배열에 저장된 좌표 수 만큼 반복문을 반복하면서 상,하,좌,우 값을 모두 `0`으로 초기화한다.

## 핵심
* `0`인 원소 좌표 값을 찾는게 핵심이다.

## 문제점
