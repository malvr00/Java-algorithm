# [Rotate Image](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step21/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/rotate-image/description/)) <br/>
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).<br/>
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.<br/>

## 해법
* `matrix` 배열을 완전복사한 또 다른 2 차원 배열 `temp`을 초기화한다.
* `iTh` 행을 맨 오른쪽 열 부터 차례로 `90 도` 회전시켜 값을 저장한다.

## 핵심
* 완전복사해서 기존 배열 값을 가지고있고, 새로 초기화해야하는 `matrix` 값을 바꿔준다.

## 문제점
