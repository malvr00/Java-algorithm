# [Merge Intervals](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step6/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/merge-intervals/description/)) <br/>
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

## 해법
* `intervals` 범위 값을 병합해야 하기 때문에 `[0]` 시작 값을 기준으로 오름차순으로 정렬한다. 
* `intervals[0]`을 맨 처음 배열에 저장한다.
  * 범위의 초기 시작지점이기 때문에 '0' 번 인덱스 값을 바로 저장한다.
* '1' 번 인덱스부터 `intervals`를 탐색한다.
* 범위 기준이되는 `cur` 병합을 확인할 `nur` 의 범위를 확인한다.
  * `cur[1]` 마지막 범위 값이 `nur[0]` 시작 지점 값 보다 크거나 같을 경우 `cur[1]`의 값을 `cur[1], nur[1]` 값 중 더 큰 값을 `cur[1]`에 초기화한다.
  * `cur[1]` 마지막 범위 값이 `nur[0]` 시작 지점 값 보다 작을 경우 `cur` 값을 `nur` 값으로 초기화한 후 `cur` 값을 정답 배열에 저장한다.

## 핵심
* `[0]`값을 기준으로 정렬 후 `cur[0], nur[1]`의 범위 비교 후 값을 저장해야한다.

## 문제점
* 문제 해석할 때 `intervals[i] = [starti, endi]` 값이 수의 범위가 아니라 인덱스로 서로 연결되어있는 문제로 해석해서 문제풀이에 차질이 생겼다.
* 지문이 헷갈린다면, 주어지는 정답 예시부분을 심도있게 봐야겠다.