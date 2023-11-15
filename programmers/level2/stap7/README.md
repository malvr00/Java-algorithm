# [뒤에 있는 큰 수 찾기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap7/src/Main.java)

값이 주워지면 주어진 값이 목표 값까지 최소 카운트를 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/b91098dc-cc74-4ba4-9834-d7f00cd9e9df" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/17ccf698-1bdf-4cd9-be1a-db96eb2af80c" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 첫 번째: x 의 값을 y 값으로 만들어야 하는데 y 값으로 구하는 경우의 수는 x * 2와 2 * 3 그리고 x + n 3 가지 방법이다. <br/>
  최소의 값을 빠르게 구해야 했기 때문에 BFS를 활용해 풀어냈다.
* 두 번째: x의 값이 작고 y의 값이 큰 경우 시간 초과가 발생 할 수 있기 때문에 이미 BFS 순환 중 이미 구한 값이 존재하면 <br/> 
  Queue에 저장하지 못 하도록 체크하는 배열을 하나 만들어줬다.



## 문제점
* 첫 번째: 문제를 제대로 파악하지 못해 처음에는 x에 n값을 한번만 더한 후 y의 값이 되면 1 리턴하고, <br/>
  x의 값에 2를 계속 곱한 값이 y가 되면 카운트 1차로 저장하고 x의 값에 3을 계속 곱한 값이 y이가 되면 카운트를 2차로 저장 후 <br/> 
  1차로 구한 값과 2차로 구한 값을 비교해 더 작은 값을 리턴 되도록 구현했었는데, 문제 지문을 잘못 파악해 정답이 나오지 않았다. <br/>
* 두 번째: x에 값을 2만 곱하는게 아니라 x에 2를 곱한 후 추가로 2를 곱할 수 도 있고 3을 곱할 수 도 있고 n을 더할 수 도 있다는 걸 파악했다. <br/>
  문제 파악 후 for문으로 만 구현하던 코드를 BFS 형식으로 변경하여 문제를 풀었지만 시간초과가 발생했다.
* 세 번째: 두 번째 시도에서 시간초과가 되면서 문제점을 파악했는데, BFS가 돌 때 이전에 구한 값을 다시 <br/> 
  Queue에 저장해 쓸모없는 값을 반복하는 문제를 막고자 값을 이미 구한적이 있는지 체크하는 배열을 하나 추가했다. 
  문제 최대로 주어지는 값이 1,000,000 이므로 1,000,001의 배열을 미리 할당해서 값을 연산한 num을 index로 활용해 이미 구한적이 있는지 체크했다.<br/> 
  처음에 List로 add 후 contains로 체크 할까 싶었지만 List의 contains는 시간 복잡도가 O(n) 이여서 배제하고, <br/> 
  Hash 또는 배열을 미리 할당하는 두 가지 방법중 하나를 택해 구현했다. ( Hash의 contains의 시간 복잡도는 O(1)이다 ) <br/>
