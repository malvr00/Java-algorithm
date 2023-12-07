# [괄호변환 (KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap32/src/Main.java)

괄호 값이 들어있는 String p 가 주어지는데 ‘()’ 올바른괄호와, ‘)(‘ 균형잡힌괄호 문자열 두 가지가있다. p를 u와 v로 분리해야 하는데 u가 올바른괄호 또는 균형잡힌괄호가 될때까지 u에 값을 누적하고 나머지 값은 v에 누적한다. 그 후 지문에 올바른괄호 문자열 일 경우와 균형잡힌괄호 문자열 일 때의 조건을 처리해주면 된다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/12da020f-08a9-423f-95c2-3d9459106fe7" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/ccece81c-6b2c-4117-94eb-7ddf95740974" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/2ef74da7-e506-449c-9df4-e94bd1a18d82" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 문제의 지문에 나와있다 시피 재귀호출 해야 하므로, p(v) 값이 올바른괄호 이거나 빈 값일 때 리턴
* 두 번째: p(v)를 u와 v로 분리 후 u가 올바른괄호 인지, 균형잡힌괄호 인지 판단한다.
* 세 번째: u가 올바른괄호 일 경우 u는 그대로 둔 후 v를 기준으로 재귀호출 해 처음부터 다시 실행 후 리턴
* 네 번째: u가 균형잡힌괄호 일 경우 v를 재귀 호출 후 반환 된 값을 가지고 ‘(‘ 를 먼저 빈 값에 누적 후 v에서 반환된 값을 이어붙인 후 ‘)’ 닫는 괄호를 다시 추가 후 u의 처음과 끝을 제거한다.
* 다섯 번째: u에 값이 남아있다면 남아있는 값의 괄호를 뒤집어 누적된 값에 추가로 누적 후 리턴해준다.




## 문제점
* 첫 번째: 문제 지문 파악이 너무 힘들었다. 문제설명의 3-1과, 4-4의 지문을 잘못 파악해 시간이 오래걸렸다. 카카오 문제는 지문을 정말 잘 파악해야겠다.