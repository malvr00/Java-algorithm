# [큰 수 만들기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap37/src/Main.java)

String 값 안에 숫자 값이 주어지는데 주어진 숫자 값에서 String.length() - k 길이 만큼의 숫자를 조합해 가장 큰 수를 출력해야하는 문제다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/ba8986f0-416c-48f6-9ce8-e65625b0094c" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 String의 길이 값과 k 값의 차를 구해 구해야하는 숫자 길이(len)를 구한다.
* 두 번째: len을 기준으로 반복문을 돌면서 String 값을 k길이 만큼의 숫자들 중 가장 큰 수를 answer에 저장한다. 숫자 크기 비교의 기준은 선택된 index + 1을 기준으로 선택한다.


## 문제점
첫 번째: 아직 그리디 알고리즘을 구현할 때 기준을 잘 잡지 못하는 부분이 문제이다. 첫 반복문을 선택 할 때 len을 기준으로 한칸 한칸 채워나가야 했는데 주어지는 String을 기준으로 문제를 해결하려 했더니 문제풀이가 난해해졌다..