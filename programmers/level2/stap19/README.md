# [k 진수에 소수 개수 구하기(KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap19/src/Main.java)

숫자 n이 주워지면 k진법으로 바군 후 0의 옆에 숫자가 존재 할 경우 그 숫자가 소수인지 판별하는 문제이다. <br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/c7489bf0-9449-4c5a-b020-803d55982860" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/c3c3e6ed-ebba-48de-9439-d97ab4194e95" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째:  우선 k진법으로 변경 후 for문을 돌면서 0이 아니면 String에 값을 더하고, 0 이면 합한 String 값을 long 타입으로 변경해 소수인지 판별한다.
* 두 번째: 소수인지 판별 후 소수라면 카운트를 증가한다. 그리고 for문을 탈출 했을 때 String에 값이 남아있을 경우 한번 더 소수인지 판별한다.



## 문제점
* 첫 번째: 소수를 판별하는 함수에서 문제 발생했다. 2, 3, 5, 7의 배수만 체크 했더니 실패했다.
* 두 번째: 2, 3, 5, 7 배수만 체크 하지 않고 소수 판별 하기 위해 n 값이 들어오면 2부터 n 직전까지 for문을 반복했다. 그 결과 시간초과가 발생해 실패했다.
* 세 번째: n 값의 크기가 큰 경우 문제가 발생한 점을 파악해 n의 제곱근을 구한 후 2부터 제곱근 값까지 비교해 통과했다.