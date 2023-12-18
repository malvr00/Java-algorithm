# [더 맵게](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap45/src/Main.java)

맵기 스코프 값을 배열에 담아서 전달해준다. 전달 해준 스코프 값을 ( 가장 안 매운 스코프 + 두번째로 안 매운 코프 * 2 )의 공식으로 변환해서 원하는 스코프 이상의 값이 나올 때 까지 반복한다. 처음부터 비교 할 값이 없으면 0 출력하고 비교도중 더 이상 숫자를 합해 원하는 스코프 이상 값이 못 나올 때 -1을 출력한다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/6f742f0c-7ecd-41ed-8832-0dc83b73d97e" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/d82a087d-8678-4537-a07a-84531b22067a" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 가장 안 매운 값만 계속 뽑아야하기 때문에 Heep을 활용했다.
* 두 번째: Heap에서 값을 빼내서 위의 공식을 대입해 몇 번 반복 했는지 카운트를 증가 시켜준 후 정답을 출력한다.




## 문제점
* 첫 번째: 처음시도 했을 때 오름차순 정렬 후 문제를 해결하려 했으나 효율성 테스트에서 통과하지 못 했다. 스코프 값이 최대 100만 길이까지 주어지기 때문에 중간에 정렬이 들어가면 O(n^2) 시간 복잡도가 되기 때문에 안되는 것 같다.
* 두 번째: 정렬을 하지 않고 Heap을 활용해 문제를 해결했다. 하지만 처음부터 비교 할 값이 없을 경우 -1 을 출력하도록 만들었는데 -1이 아닌 0을 출력했어야 했다. 문제 지문이 조금 이상한 것 같다.