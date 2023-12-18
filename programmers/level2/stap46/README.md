# [짝지어 제거하기](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap46/src/Main.java)

알파벳이 들어있는 String 값을 주어주면 2 연속으로 같은 알파벳을 만나면 그 둘을 삭제하고 사이 공백을 앞뒤 문자열을 이어 붙인다. 이 작업을 반복했을 때 문자열이 남아있지 않으면 1 출력하고 아니면 0을 출력하는 문제이다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/3d489fe6-c531-4bfb-b41b-0d87b7a04db0" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: Stack에 저장된 값이 없다면 Stack에 값을 누적 시킨다.
* 두 번째: Stack에 저장된 값이 있을 때 Stack peek 값 과 알파벳을 비교 후 같다면 Stack에서 pop 한다.
* 세 번째: peek와 알파벳을 비교 후 값이 다르면 Stack에 add 한다.



## 문제점
* 첫 번째: 처음문제를 풀때 StringBuilder로 문제를 해결 했으나 효율성 테스트에서 실패했다. String의 값을 StringBuilder로 치환하는 과정에서 시간을 추가로 잡아 먹어 효율성 테스트를 통과하지 못 하는 것 같다. 결국 StringBuilder에 대입하면 같은 문자열을 2회 반복하게 되기 때문에 효울이 많이 떨어지긴 하는 것 같다.
* 두 번째: Stack으로 시도해 효율성 테스트를 통과하였다. 짝이 관련된 문제는 Stack으로 문제를 해결하는게 시간복잡도를 줄 이는데 좋은 것 같다.