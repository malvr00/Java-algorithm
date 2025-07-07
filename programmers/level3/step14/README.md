# [아이템 줍기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step14/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java)) <br/>
지형을 나타내는 직사각형이 담긴 2차원 배열 rectangle, 초기 캐릭터의 위치 characterX, characterY, 아이템의 위치 itemX, itemY가 solution 함수의 매개변수로 주어질 때,<br/> 
캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리를 return 하도록 solution 함수를 완성해주세요.<br/>


## 해법
* 동전 뒤집기의 예제 문제처럼 먼저 모든 `행의 뒤집기` 경우의 수를 먼저 구한다.
* `행 뒤집기` 마지막 리프 노드에 와서는 열 동전을 뒤집을지 안 뒤집을지 정한다.
  * `열`이 `target`과 같다면 뒤집지 않는다 -> `0`
  * `열`이 `target`과 모두 다르다면 뒤집는다. -> `1`
  * `열`이 `target`과 모두 같거나 모두 다르지 않는다면 `target`이 될 수 없다. -> `-1`
* `(행 뒤집기 + 행 뒤집기)` 횟수를 저장해둔 `answer`와 비교 후 더 작은 값을 저장한다. 

## 핵심
* 이 문제의 핵심은 행의 경우의 수와 열의 경우의 수를 모두 탐색하면 시간초과에 걸릴 확률이 높다.<br/>
* 문제 예시에서 보는 것 처럼 행을 먼저 뒤집고, 그 후에 열을 탐색하면 쉽게 문제를 해결할 수 있다.

## 문제점
* 문제의 핵심 파악이 힘들었다. 재귀호출 문제를 많이 풀어봐야겠다.