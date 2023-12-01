# [거리두기 확인](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap24/src/Main.java)

대기실에 면접 대기자 ‘P’가 있는데 두 자리씩 간격을 두고 앉거나 블라인드 ‘B’가 쳐져 있어야 한다. 거리 계산식은 |x1-x2| + |y1 - y2| 인데 값이 3 이상 이거나, 2이하 일 경우 블라인드 ‘B’가 쳐져 있는지 확인해 블라인드가 없다면 0 을  블라인드가 있다면 1을 정답 배열에 담아야 한다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/f2fd05d2-3f6b-4cdc-9ad6-e9c057623078" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/aacca5d8-8315-4d68-a6e5-0402c5b4ee5a" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/61eeb991-e246-45f6-8e7a-05b41c6ed6ac" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/b88d2860-d217-4147-a389-c22cf93bd747" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 5x5 형태의 배열의 값이 주어지고, [x]는 대기실 하나를 의미한다.
* 두 번째: 대기실 하나씩 비교 도중 대기자 ‘P’를 만나면 BFS 실행한다.
* 세 번째: BFS 실행 중 다른 대기자 ‘P’를 만났을 때 대기자의 간격을 계산해 3 이상인지 체크하고 만약 2 이하라면 대기자 ‘P’와 대기자 ‘P’ 사이에 블라인드 ‘B’가 있는지 확인하고 블라인드 ‘B’가 없다면 false를 반환해 0을 저장하도록한다.
* 네 번재: BFS 에서 0 이 반환된다면 0 이 반환된 대기실은 두 자리씩 간격을 두고 있지 않기때문에 바로 종료한다.



## 문제점
* 첫 번째; 대기자 ‘P’와 대기자 ‘P’가 만났을 때 블라인드의 좌표 값을 찾기가 어려웠다. 그리고 좌표를 찾기 이전, 거리 계산식을 사용하지 않고 count만 활용해 문제를 해결 했을 경우 테스트 케이스를 실패했다. 다시 한번 문제를 잘 읽어봐야한다고 다시 상기한다…