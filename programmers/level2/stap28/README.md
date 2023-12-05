# [이진 변환 반복하기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap28/src/Main.java)

String s 변수에 2진수의 값이 주워지는데 먼저 0의 개수를 구하고 0이 존재한다면 0을 제거 후 s의 길이를 구해 s의 길이만큼 2진수로 다시 변환한다. s의 값이 1이 될때 까지 무한 반복하면 된다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/f9211de5-1de3-44b0-a104-9552d86bce1d" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/fb605793-edb3-490e-a496-5fa0cbb25bd1" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 s 값에 0이 몇개 포함 됐는지 카운트를 늘려준다.
* 두 번째: s 값에 0을 제거한다.
* 세 번째: s의 길이만큼 2진수 값을 구해 1이 나올때 까지 반복한다.


## 문제점
x