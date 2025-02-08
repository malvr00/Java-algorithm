# [Longest Repeating Character Replacement](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step13/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/longest-repeating-character-replacement/description/)) <br/>
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.<br/>
Return the length of the longest substring containing the same letter you can get after performing the above operations.

## 해법
* 먼저 문자열 `s` 원소들을 `map`에 카운팅하면서 전체탐색을 한다.
* 탐색 도중 `가장 중복이 많은 원소 값 카운트`를 변수 `maxCnt`에 저장한다.
* 범위를 지정한 변수 `start`와 반복문 변수 `end`를 저장한 범위로 규정하고 `가장 큰 중복 원소` 값을 찾는다.
* 문제에서 `k` 만 큼 원소를 자신이 원하는데로 변경할 수 있는데, 원소를 변경하는 기준은 아래와 같다.
  * `(end - start + 1) - maxCnt`가 `k` 보다 크다면, 더 이상 `중복 원소 범위`가 아니기 때문에 `k` 만 큼 변환을 했을 때 `중복 원소 범위`가 되는 시작지점의 값을 찾을 때 까지 반복한다.
    * ex) `s = 'AABABBBB', k = 1`일 때 저장 범위가 `0 ~ 4`까지 일 때 시작지점을 `2` 까지 증가시켜야 한다. 그렇게 되면 `3 번 인덱스`에 있는 `A`를 한번만 `B`로 다시 변경하면 `중복 원소 범위`를 찾게된다.
* 마지막으로 `end - start + 1`과 저장된 `가장 큰 중복 원소 범위 길이` 중 더 큰 값으로 계속 저장하며 마지막에 정답을 반환한다.

## 핵심
* 슬라이딩 윈도우에 저장된 값에서 `k` 번 초과변환이 일어났을 때 슬라이딩 윈도우 범위를 재설정해주는게 중요하다.

## 문제점
* `s = AABAABBB, k = 1` 이렇게 값이 주워줬을 때 `AABAAB`의 저장 범위에서 중간 `A`의 값을 빼기가 어려웠다. 