# [최소 회의실 개수](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap4/stap4-7/src/Main.java)
현수가 다니는 기업에서 여러개의 회의가 동시에 진행되는 행사를 기획하고 있습니다. 매개변수 meetings에 각 회의의 시작시간과 끝시간이 주어지면 이 모든 회의들을 진행하기 위 해 최소 몇 개의 회의실이 필요한지 구하는 프로그램을 작성하세요.<br/>
하나의 회의실에서는 하나의 회의만 할 수 있습니다.
<br/>

## 내가 푼 방식
- 회의시간을 시작 시간을 기준으로 정렬을 진행 한다.
- 정렬된 값을 반복문을 돌 때 우선순위 큐에 종료 시간을 넣고 만약 우선순위 큐에 값이 있을 경우 회의 시작시간과 비교하여 다음 회의 시작시간이 같거나 클 경우 우선순위 큐에서 루트 값을 삭제한다
  - 시작시간보다 크거나 같지 않을 때는 무조건 큐에 값을 넣는다. 이렇게 될 경우 큐의 크기가 곧 필요한 회의실의 개수이다.
<br/>

## 강의
- 배열에 시작시간과 종료시간의 식별할 수 있는 값으로 저장한다
  - ex) {10, 1}, {10, 2} -> 1은 시작시간, 2는 종료시간이다.
- 배열 값을 반복문을 돌면서 시작시간일 경우 카운트를 1 증가 시키고 종료시간은 1 감소 시킨다. 마지막으로 카운터와 answer를 비교해 큰 값을 보다 큰 값을 answer에 저장한다.

<br/>

## 차이점
- 강의에서는 시작시간과 종료시간을 따로 구분해서 저장한 후 한번의 반복문으로 문제를 해결한 반면, 내가 푼 문제에서는 우선순위 큐를 사용해서 반복문을 한번 더 사용했다.
  - 우선순위 큐가 반복문을 한번 더 돌긴하지만 시간복잡도도 작고 필요로 하는 회의실의 값이 크지 않을 것으로 예상되기는 한다. 하지만 강의에서 푼 방식이 더 좋아보이긴한다. 