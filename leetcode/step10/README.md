# [Top K Frequent Elements](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step10/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/top-k-frequent-elements/description/)) <br/>
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

## 해법
* `nums`의 원소들을 카운팅해서 `map`에 저장한다.
* `map`에 저장된 원소 값을 직접 구현한 클레스에 담아서 우선순위 큐에 담는다.
  * 가장 비번히(frequent) 사용된 `k` 개의 원소를 출력해야하기 때문에 `map.value()`를 기준으로 내림차순 정렬한다.
* 우선순위 큐에 저장된 값 들을 `k` 번 만큼 반복문을 돌면서 꺼내 정답 배열에 저장 후 반환한다.

## 핵심
* 문제는 단순한데 문제 해석을 잘해야한다. 빈번히 사용되는 `k` 개 원소를 찾아야한다. 

## 문제점
* 처음에 문제를 잘못 이해해서 `k` 개 만큼의 중복 원소를 반환했다가 실패했다.