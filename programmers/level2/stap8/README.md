# [택배 배달과 수거하기(KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap8/src/Main.java)

트럭에 최대 실을 수 있는 택배 박스 개수가 주어지고 각 집마다 택배를 배달 해 주거나, 택배 상자를 수거해와야 하는데,<br/>
그 경로 중 가장 최적의 경로의 값을 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d9273e29-9138-4ed1-9191-584dd8c7275d" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/003637fb-ad72-4087-aa17-ede6f2386973" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/03749210-8d6f-4300-ad55-778f38caebfd" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 첫 번째: 배달이 완료했는지, 수거가 완료됐는지 파악 하기 위해서 Stack을 활용했다.
* 두 번째: Stack에 deliveries Stack, pickups Stack 각각 만들어 준 후 Stack에 저장 했다.
* 세 번째: 문제 예제를 보면 뒤에서 부터 시작 하는 모습이 보여 뒤에서 부터 Index가 뽑히도록 지정했다.
* 네 번째: Stack에 두 개중 하나라도 값이 있을 경우 진행하고, 배달 거리는 Stack에서 뽑혀 나온 index 2개를 비교해 큰 수를 저장해 주는 식으로 진행했다.
* 다섯 번째: 택배 배달을 먼저 시작하는 로직을 구현 후 수거하는 로직을 실행했다. 각 로직이 끝나면 cap을 초기화



## 문제점
* 첫 번째: 배열의 길이가 최대 100,000 인 것을 제대로 보지 않아 처음에는 BFS로 진행 했으나.. 시간 초과가 발생해 실패했다.
* 두 번째: 배달을 했는지, 수거를 했는지에 대한 한 쌍의 값을 비교해 answer에 누적해 나가야 했기 때문에 Stack을 활용했다.