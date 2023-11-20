# [귤 고르기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap11/src/Main.java)

상자에 귤을 담을 수 있는 정수와 수확한 귤이 담겨있는 상자 값 배열이 주어지고 몇 종류의 귤을 상자에 담을 수 있는지 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/b26c9bc7-e476-4282-8869-417c2427f720" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 상자에 담긴 귤의 종류 또는 최적의 값을 구하는 문제가 아닌 단순 상자에 담을 수 있는 귤의 종류만 구하면 되는 문제이기 때문에 Map을 사용했다.
* 두 번째: Map을 통해 귤의 종류는 Key로 귤 종류의 개수를 value에 카운트를 늘려주는 방식으로 저장했다.
* 세 번째: 귤 종류의 개수를 모두 구했으면, Map의 value를 기준으로 내림차순으로 List에 저장 후 for문을 돌면서 answer가 증가하며, k의 값을 빼면서 0이하로 내려 갔을 때 answer을 리턴 해준다.




## 문제점
-