# [무인도 여행](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap5/src/Main.java)

1x1크기의 칸으로 이루어져있는 맵에 무인도에 체류 시 식량이 며칠이 필요한지 구하는 문제이다. <br/>
맵에 무인도는 여러곳이 존재하고, 무인도 정보 안 에는 식량의 정보들이 담겨있다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/852c6e99-0162-442f-a113-64761b6b6324" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/3664ef77-fe20-4ec2-81a3-268e0dc48d1a" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 첫 번째로 모든 무인도를 탐색해야 하기 때문에 BFS 보단 DFS로 문제를 풀었다.
* 두 번째로 맵에서 바다가 아닌 무인도를 만날 시 무인도에 표기된 식량 값을 더해 나간 후 모두 구했다면 배열에 저장해 주었다.
* 마지막으로 배열의 길이가 0이라면 방문 할 수 있는 무인도가 없다고 판단하여 -1을 출력하도록 구현했다. 
