# [Isomorphic Strings](https://github.com/malvr00/Java-algorithm/blob/master/leetcode/step14/src/Main.java)

([자세한 문제는 LeetCode 참고](https://leetcode.com/problems/isomorphic-strings/description/)) <br/>
Given two strings s and t, determine if they are isomorphic.<br/>
Two strings s and t are isomorphic if the characters in s can be replaced to get t.<br/>
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

## 해법
* 주어지는 값 `s`와 `t`를 문자열을 비교한다.
* 탐색을 하면서 각 `s - t -> Map<'문자', '인덱스'>`에 저장한다.
* `Map`에 저장하기 전 `Map.value()` 값에 있는 인덱스를 꺼내와 값을 비교한다.
  * `tMap`과 `sMap`의 해당 문자의 인덱스 값이 다른 경우 `s`와 `t`의 각 문자열의 연속된 문자가 매칭이 되지않아 `FALSE`를 반환한다.

## 핵심
* 인덱스 값을 비교할 때 인덱스의 값이 `127`을 벗어나기 때문에 `==`로 비교하면안되고 `Objects.equals`로 `tMap, sMap`의 값을 비교해야한다.

## 문제점
* Integer형의 한 객체로 관리되는 숫자가 `-128 ~ 127`까지의 범위인지 처음알았다... 앞으로 주의해야겠다. 