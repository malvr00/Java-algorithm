# [구명보트](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap36/src/Main.java)

사람을 최대 2명까지 탑승이 가능한 구명보트가 있는데, 최소한의 구명보트를 이용해 사람들을 구출하는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d2693997-a04d-4bdb-b97a-ea548cac9b62" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 사람 몸무게를 기준으로 오름차순으로 정렬한다.
* 두 번째: 구명보트는 사람 최대무게보다 항상 크기 때문에 항상 구명보트 숫자를 1 증가한다.
* 세 번째: 맨 처음(LT)과 맨 끝(RT)을 합해 구명보트 보다 같거나 작으면 LT 를 1 증가 시킨다.
* 네 번째: RT 는 항상 감소해 구명보트에 탑승시킨다.


## 문제점
x