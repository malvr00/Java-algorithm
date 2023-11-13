# [뒤에 있는 큰 수 찾기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap6/src/Main.java)

배열에 값이 주어지면 현재 위치가 뒤에있는 값 보다 작으면 뒤에 있는 더 큰 값을 배열에 누적해 출력 하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/10ef625a-1dfb-4f44-a064-c741450314c0" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 첫 번째로 Stack에는 배열의 index를 저장했고, Stack을 활용해 값의 크기를 비교 하도록 만들었다.
* 마지막으로 Stack에 값이 남아있다면, 남아 있는 값들은 뒤에 수 보다 모두 큰 수 이므로 -1을 저장해주도록 했다.

## 문제점
* 첫 번째 시도: while문과 two point 알고리즘을 활용해 문제를 해결하려 했으나, 시간 초과문제가 발생하여 실패했다.
* 두 번째 시도: Stack에 index를 저장하고, for문이 돌 때 for문의 값이 Stack 맨 위에 있는 index 값 보다 크다면, <br/> 
  index 위치를 기준으로 뒤에있는 가장 큰 수로 만났으므로 미리 만들어 둔 answer 배열에 저장한다. for문이 종료 후 Stack에 값이 남아있다면, <br/> 
  남아 있는 값들은 뒤에 수 보다 모두 큰 수 이므로 -1을 저장해주도록 했다.
