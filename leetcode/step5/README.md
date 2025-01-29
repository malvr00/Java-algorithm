# [Kth Largest Element in an Array](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step5/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/kth-largest-element-in-an-array/description/)) <br/>
Given an integer array nums and an integer k, return the kth largest element in the array.<br/>
Note that it is the kth largest element in the sorted order, not the kth distinct element.<br/>
Can you solve it without sorting?

## 해법
* 주어지는 `nums`를 오름차순으로 정렬한다.
* 정렬 후 `nums[nums.length - k]`를 정답으로 반환한다.

## 핵심
* 문제에서 정렬 후 인덱스 번호가 아닌 해당 `k` 번 째로 큰 값을 반환하는 문제이기 때문에 해당 배열을 정렬 후 문제를 해결한다.

## 참고
* 정렬을 사용하지 않고 문제를 해결하려면, `PriorityQueue`를 활용해서도 문제 풀이가 가능해 보인다.