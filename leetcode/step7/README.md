# [Longest Substring Without Repeating Characters](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step7/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)) <br/>
Given a string s, find the length of the longest substring without duplicate characters.

## 해법
* 주어지는 `s`를 기준으로 `O(n)`으로 문제를 해결한다.
* `Map<'char', 'Index'>`에 해당 `s.charAt(i)`의 값이 존재 할 경우 범위를 초기화한다.
  * 예를들어 `0 ~ 3`번 인덱스까지의 값을 저장하고 있을 때 `Map`에서 나온 인덱스 값이 `2`인 경우 시작지점 변수 `start`를 `Map.value() + 1`로 초기화한다.
    * 여기서 중요한 점은 `Map.value()`의 값이 `start`보다 크기가 큰 경우에만 `start`의 값을 초기화한다.
      * `abba`의 값을 보면 `ab`까지 초기에 저장하고 `start`의 값은 `0` 이떄 다음 `b`를 보면 `1` 인덱스 값이 뽑혀나오고 `start`는 `2`로 초기화된다. 그 다음 `a`를 만났을 때 `0`의 값이 뽑혀나오고 `start`는 `2`의 값을 가지고 있기 때문에 `start` 값을 초기화하지 않는다.
        * 이렇게 하지 않을 경우 `start = 2` 였던 값이 `start = 1`로 초기화되면서 오답이 출력된다.
* 검증이 완료되면 `Map<'char', 'Index'>`에 값을 저장한다.
* 마지막으로 정답변수와 `i - start + 1`과 비교해서 더 큰 값을 정답 변수로 다시 초기화 후 마지막에 반환한다.

## 핵심
* 윈도우 슬라이드 방식으로 문제를 해결해야 하며, 윈도우 슬라이드의 범위 값 `start` 초기화 조건식을 잘 세우는게 핵심이다.

## 문제점
