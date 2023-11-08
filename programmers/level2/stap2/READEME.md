# [연속된 부분 수열의 합](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap2/src/Main.java)

연속된 부분 수열의 합의 최소 index 범위 찾기 <br/>
<img src="https://github.com/malvr00/Java-Study/assets/77275513/41d9e0a3-fc58-420d-8953-c5b1fd572465" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-Study/assets/77275513/affb8678-f78b-41d2-8dc9-208273ad066e" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 입력된 값을 합해 k 값이 나왔을 때 합한 인덱스의 범위가 가장 작은 값을 출력하는 문제이다. <br/> 
  범위가 1,000,000 이기 때문에 2중 for문으로 처리한다면 타임 오버가 발생 할 것 같아서 slide window를 활용해 시간복잡도를 대폭 줄였다.
* 첫 번째로 lt 라는 변수를 생성해 합산 시작 지점의 인덱스를 할당해 줬다.
* 두 번째로 합산한 값이 k의 값보다 크거나 같은 경우 lt 값 부터 합 한 값에 빼 후 lt의 값을 증가 시켜 다음 index를 가르키도록 만들어 주고, <br/>
  만약 뺀 값이 k와 값이 같다면 기존에 저장된 시작 index 와 마지막 index의 합한(index 길이의 합) 값 보다 작다면 새로 갱신하다. <br/>
  그리고 만약 합한 값이 k값보다 작아질때까지 반복하여 빼주도록 구현하였다. <br/>
