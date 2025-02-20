# [Find All Anagrams in a String](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step17/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/find-all-anagrams-in-a-string/description/)) <br/>
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

## 해법
* 슬라이딩 윈도우로 문제를 해결해야하는데, 먼저 `p.length - 1` 만큼 맵에 `s` 문자를 `Map`에 카운팅해서 저장하고 `p` 문자열의 문자 값도 새로운 `Map`에 저장한다.
* 이제 `p.length - 1`부터 `s`를 탐색하면서 문자열 값을 저장하고 `p` 문자열과 같은지 확인한다.
* `s` 값을 저장한 `Map`의 값이 `p` 문자열 저장한 `Map`에 값이 존재하고, 문자 수가 같다면 `flag` 변수를 `TURE`로 반환하고 그 외의 경우는 `FALSE`로 초기화하고 검증을 종료한다.
* `flag`가 `TRUE`라면 해당 범위 시작 값 `lt`의 인덱스 값을 정답 배열에 넣은 후 `s` 문자가 저장되어있는 `Map`에 맨 오른쪽 인덱스에 있는 문자 카운트를 1 감소 시킨다.
* `s` 문자열 탐색이 완료됐다면, 정답배열을 반환한다.

## 핵심
* 슬라이드 윈도우로 문제를 해결하는게 핵심이고, 초기에 문자를 범위에 저장시키는 초기작업이 중요하다.

## 참고
