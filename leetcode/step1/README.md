# [towSum](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step1/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/two-sum/)) <br/>
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.<br/>
You may assume that each input would have exactly one solution, and you may not use the same element twice.<br/>
You can return the answer in any order.

## 해법
* 주어진 배열 `nums`를 반복문을 돈다.
* `target` 값과 `nums[i] + nums[j]`의 값이 같으면 정답을 출력한다. 

## 핵심
* `nums`의 원소가 `target`이 되는지 확인만하면 되는 간단한문제.

## 문제
* 여기서 문제가 하나 있는데 `nums`길이가 `10^4` 길이만 주어줬지만 이 보다 더 긴 길이가 주어질 경우 `O(n^2)`으로는 시간초과가 발생할 수 있다.
  * 길이가 길어졌을 때 시간 초과가 나지 않게하기 위해서는 `Map`을 활용해서 `Map`의 `Key`에 원소값을 넣고 `Value` 값에는 인덱스 값을 넣어서 `Map.get(nums[i]) - target` 값이 `Map.containsKey(k)`에 존재 할 경우 정답을 반환하면 `O(n)`으로 문제 해결이 가능하다
