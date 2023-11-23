# [두 큐 합 같게 만들기 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap16/src/Main.java)

길이가 같은 큐 두개가 주어지면, 큐 두개의 합이 만약 30이라면 큐 합의 값이 15, 15로 떨어지게 만들어야한다. 큐 두 개중 하나를 기준을 잡고 insert, pop을 진행해 합을 맞춘다. Insert, pop이 한번 진행 되면 1회 실행으로 치며 카운트를 증가시킨다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/f17938c5-dfce-485a-a7b9-6361b3b91843" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/9e31e041-2fc1-45e4-8021-b814037132d9" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 큐1을 기준으로 작업을 진행했따.
* 두 번째: 큐1, 큐2의 합과 큐1의 합을 저장하고, List로 큐1부터 차례로 저장해 두 개를 하나로 만들었다.
* 세 번째: 큐1을 기준으로 작업 했기 때문에 큐1의 시작지점 lt 0 큐1 마지막 지점 rt를 큐1 길이만큼 먼저 초기화해서 큐1의 범위를 지정했다.
* 네 번째: 그 후 반복문을 도는데 먼저 q1의 합이 큐의 총합 / 2 일때 까지 반복하도록하고, 반복문 안에 반복문 2개를 추가로 더 사용했는데, 반복문 1번은 큐1의 합이 큐의 총합 / 2 보다 같거나 크면 카운트가 증가하면서 lt의 위치를 증가시키며 큐1의 합을 빼주었다. 반복문 2번은 큐1의 합이 큐의 총합 / 2 보다 같거나 작다면 rt의 위치를 증가시키며 큐1의 합을 더해줬다.
* 다섯 번째: 합이 나올 수 없는 경우 -1을 출력해야하는데 이부분은 시작지점인 lt가 List 길이 끝까지갔다면 더 이상 값이 나올 수 없기때문에 -1을 출력하도록 했다.



## List로 문제 해결한 이유
* 두 개의 큐가 주어질때 큐를 가지고 Insert, pop을 진행 할 수 있지만 결국 카운트만 뽑아내면 되기 때문에 이 방법은 비효율 적이라 판단하여 하나의 List로 바꿔서 문제를 풀어나갔다.