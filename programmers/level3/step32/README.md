# [단속카메라](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level3/step32/src/Main.java)

([자세한 문제는 프로그래머스 참고](https://school.programmers.co.kr/learn/courses/30/lessons/42884)) <br/>
고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.

## 해법
* 먼저 `routes`를 진출 값 `[i][1]`를 오름차순 정렬을 진행한다.
* 진출 최소 값을 저장할 `lastOut` 변수를 하나 생성한다.
* 정렬된 `routes`를 가지고 탐색을 진행한다.
  * `routes[i][0]` 진입 원소 값이 `lastOut`보다 크다면 해당 `routes[i][1]` 값을 `lastOut`에 저장 후 `answer`를 증가시킨다.
    * `lastOut`에 `routes[i][1]` 값을 저장하는 이유는 `lastOut`이 `routes[i][0]`보다 작다면 현재 설치되어있는 카메라 위치 `lastOut`의 값이 `routes[i]` 차량을 커버하지 못해 새로운 카메라 위치를 `routes[i][1]` 위치로 초기화 해야한다.
* 마지막으로 정답을 반환한다.

## 핵심
* `routes` 정렬 기준을 어떻게 잡을지가 핵심이다.
  * `[i][0]` 기준으로 오름차순하거나, `[i][1]` 기준으로 오름차순 정렬해도 문제해결하는데 문제가 없다.

## 문제점
