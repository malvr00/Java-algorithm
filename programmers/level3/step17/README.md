# [가장 긴 팰린드롬](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step17/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/12904)) <br/>
앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬(palindrome)이라고 합니다. <br/>
문자열 s가 주어질 때, s의 부분문자열(Substring)중 가장 긴 팰린드롬의 길이를 return 하는 solution 함수를 완성해 주세요.<br/>
예를들면, 문자열 s가 "abcdcba"이면 7을 return하고 "abacde"이면 3을 return합니다.<br/>
<br/>
제한사항<br/>
문자열 s의 길이 : 2,500 이하의 자연수<br/>
문자열 s는 알파벳 소문자로만 구성


## 해법
* 문자열이 주어지면 해당 문자열을 반복문으로 탐색한다.
* 기준이 되는 인덱스를 중점으로 왼쪽, 오른쪽으로 `1 증가 && 1 감소` 하면서 팰린드롬인지 확인한다.
  * 팰린드롬의 문자열일 경우 좌우 인덱스를 증가 및 감소 시키면서 최대 길이의 팰린드롬의 수를 찾는다.
* 팰린드롬의 길이 중 가장 긴 값을 반환한다.

## 핵심
* 기준이 되는 문자를 중심으로 팰린드롬이 되는지 안되는지 빠르게 판단해서 탐색 수 를 줄여야한다.
* 팰린드롬은 홀수 짝수로 생각하면 편하다.

## 문제점
