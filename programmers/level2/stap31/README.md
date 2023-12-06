# [튜플 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap31/src/Main.java)

String s에 “{{1,2},{2}}’” 형식의 값이 주어지는데 순서대로 출력되도록 answer에 원소 값을 쌓아야한다. Ex) answer = [2, 1]<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/86e62309-2e96-4e50-9887-8241c198f318" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/5f7867e1-afab-4758-afd4-035a423d0922" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: String s를 List<List<int>> 형의 배열에 저장해야한다. 먼저 ‘{‘를 제거하고 ‘,’ 기준으로 split을 해준다.
* 두 번째: split을 하기전에 첫 번째 글자가 ‘,’ 일 경우 첫 글자 ‘,’ 만 제고 후 배열로 만들고 그게 아니면 ‘,’ 기준으로 split 했다.
* 세 번째: 새로운 배열에 저장이 끝나면 List.size()를 기준으로 정렬 후 answer에 저장된 값과 비교해 값이 없으면 추가하고 있으면 다음 숫자와 비교해 계속 값을 쌓아나간다.




## 문제점
* 첫 번째: List.size()로 sort 하는 방법이 기억이 잘 나지 않았다.