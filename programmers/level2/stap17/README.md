# [양궁 대회 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap17/src/Main.java)

어피치의 활 쏘기가 마무리된 후 라이언이 화살을 발사 했을 때 어피치 보다 큰 점수차로 이기는 경우를 구하는 문제이다. 어피치와 라이언의 점수가 같다면 어피치의 승리. ( 입출력 예제는 프로그래머스 문제 확인 )<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/4071e3c7-ada3-422f-8b7f-6a398d9d4071" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/b343c571-541e-4e1b-839a-b67191140bf9" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/315142c9-e62c-4725-b9ed-b2907f6fc2ba" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/300eeddb-2e17-415a-921a-044d7578ff2b" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: DFS로 라이언이 활을 발사하는 것 처럼 만들었다.
* 두 번째: 라이언이 화살을 모두 쏘면 어피치가 쏜 화살과 점수 비교한다.
* 세 번째: 라이언과 어피치의 점수 차가 가장 큰 값을 정답 배열에 저장한다. 하지만 점수 차가 같을 때 라이언이 이전에 쐈던 점수 보다 더 많이 획득 한다면 점수를 더 많이 얻은 값을 정답 배열에 저장한다.  점수 차가 같고 화살 점수도 같을 때 최소 점수를 가장 맞이 맞춘 값을 정답 배열에 저장한다.



## 문제점
* 첫 번째: 점수 ‘차’가 아니라 획득한 최대 점수로만 결과 값을 매겨 통과되지 못 했다.
* 두 번째: 점수 차에 대한 처리는 했지만 점수 차와 이전 획득 점수가 같을때의 처리를 제대로 해주지 못해 문제가 발생했다. 입력 예제를 꼭 제대로 확인하고 문제를 제대로 파악할 필요가 있을 것 같다.