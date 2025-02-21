# [3Sum](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step18/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/3sum/description/)) <br/>
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.<br/>
Notice that the solution set must not contain duplicate triplets.

## 해법
* 값을 3개를 합 해야하지만 중심점 맨 왼쪽 포인트는 고정하고 그 중심을 중점으로 `lt`와 `rt`를 만들어서 문제를 해결해야한다.
* `i > 0` 일 때 `nums[i] == nums[i - 1]` 일 경우 해당 원소는 건너띄고 다음 원소를 탐색한다.
* `i`를 중심으로 `lt`와 `rt`가 서로 교차하기 전 까지 탐색을 진행한다.
  * `nums[i] + nums[lt] + nums[rt]`가 `0`이면 정답 배열에 저장하는데, 이때 `lt`와 `rt`도 똑같이 중복 원소를 체크하면서 서로 증가, 감소 한다.
    * 중복원소를 제거하지 않고 단순 증가, 감소만 시행한다면 또 똑같은 원소를 마주했을 때 중복으로 정답배열에 들어갈 수 있다.
      * (아니면 `Set`을 활용하는 것도 좋을 것 같다.)

## 핵심
* 포인트를 3 개를 잡아서 문제를 해결해야 할 것 같지만 그렇게하지 않고, 포인트 하나는 전체 탐색해야하는 범위를 줄이는 용도로 중심을 잡고 `i ~ rt` 까지의 범위를 `lt`와 `rt` 값을 증감소 시키면서 문제를 해결해야한다.

## 문제점
* 포인트를 `lt, mt, rt` 이렇게 세 개를 할당하고 문제를 해결하려 했으나 증감소 시켜야하는 조건식이 답이 없어서 시작지점을 고정으로 박아두고 `lt, rt`만 활용해서 문제를 해결했다.