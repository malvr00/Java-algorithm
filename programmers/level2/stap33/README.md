# [문자열 압축 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap33/src/Main.java)

String s에 aabbcc 이런형식의 값이 주어지면 2a2b2c 형식으로 압축하는 문제이다. 그런데 abcabc의 값이 주어지면 압축이 안되기 때문에 s / 2 값 까지 압축을 진행 시키면 2abc로 압축이 가능하다. 순차적으로 압축범위를 1 ~ s / 2 까지 압축을 진행 했을 때 압축 길이가 가장 짧은 값의 길이를 리턴 시키는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/40a665fb-0317-4331-b34a-4b4d94c4e5ef" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/f4885e55-3e85-4869-a64d-a198ccafd6b2" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째 : s / 2 길이 만큼 반복문을 돈다.
* 두 번째: 반복문을 돌 때 압축하는 함수를 넣는다.
* 세 번째: 압축 함수에서 먼저 압축 할 길이만큼 버퍼에 저장 후 s 값을 비교해 result에 압축 값을 누적한다.




## 문제점
x