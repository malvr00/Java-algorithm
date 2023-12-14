# [카펫](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap39/src/Main.java)

카펫 색상인 갈색과 노란색 값을 주워지는데 노란색 색상이 갈색 색상에 둘러 싸이게 될 때의 가로, 세로의 길이를 구하는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/e66e61a0-7c60-451e-9096-0d97c39158dc" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/92ee071d-624d-44e7-96d3-44812eba64f5" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 갈색과 노란색의 값을 합해 카펫의 총 개수 (sum)를 구해준다.
* 두 번째: 총 합 해준 개수에 제곱근을 구해 세로의 값 범위를 구한다.
* 세 번째: 제곱근을 기준으로 반복문을 도는데, sum을 나눴을 때 나머지 값이 0 일 경우 세로길이의 양끝을 빼주고(-2) 가로길이의 양끌을 뺴준 후 (-2) 세로와 가로를 곱 했을때  노란색의 값이 나오면 정답을 반환한다.


## 문제점
* 첫 번째: 처음 제곱근으로 세로 값을 구한 후 나머지가 0 일 때 가로 세로를 출력하도록 했지만 테스트 케이스 4, 6, 7번이 틀리는 상황이 발생했다.
* 두 번째: 세로 값을 구한 후 가로, 세로의 값을 곱 했을 때 노란색의 값이 나온다면 정답이 되도록 검증로직을 추가 후 해결했다. 문제가 쉬워보인다고 지문을 대충읽지말고 지문의 조건을 차근차근 해결해 나가면서 문제를 풀어야된다.