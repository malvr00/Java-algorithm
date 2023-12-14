# [조이스틱](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap38/src/Main.java)

오락실 게임에서 게임을 종료 후 마지막 랭킹기록을 남길 때 이름을 선택하는 과정의 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/48a7f315-5151-4bc2-a2c4-e6feca8bd33a" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 올바르게 오른쪽 방향으로 진행된 커서이동 거리 값을 구한다.
* 두 번째: 알파벳 선택 시 ‘A’ 부터 시작할지 ‘Z’ 부터 시작할지 시작지점을 정해 기준의 차의 값을 answer에 저장한다.
* 세 번째: 다음 커서가 ‘A’ 의 알파벳을 만날 시 연속된 ‘A’ 의 index 번호를 찾아 저장한다.
* 네 번째: 연속된 ‘A’ index 값을 이용해 식을 만들어 현재 index를 기준으로 뒤로 이동했을 경우의 move 수를 구한다.
* 다섯 번째: 시작 시 뒤에서부터 왼쪽 방향으로 진행된 커서이동 거리 값에서 ‘A’를 만나 다시 뒤로 이동했을 경우의 move 수를 구한다.


## 문제점
* 첫 번째: 왼쪽, 오른쪽 커서 이동시 계산식을 구하는게 어려웠다. 계산식을 설명하자면 idx * 2 하는 이유는 현재 위치에서 뒤로 돌아가는 것 만큼 숫자를 더해야 하기 때문에 2 를 곱 해준다. 그리고 name.length() - nextIdx 는 idx * 2 는 현재 위치에서 시작지점까지 이동 값을 구했다면 이 식은 마지막 지점에서 ‘A’ 인덱스까지 거리값을 구하는 식이다.