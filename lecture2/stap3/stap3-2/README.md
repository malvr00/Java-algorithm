# [겹쳐진 압축 해제](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap3/stap3-2/src/Main.java)

압축되어있는 문자열을 압축해제 하는 문제인데 2(ab)3(b)를 압축해제 하면 2(ab)bbb -> ababbbb 방식으로 압축을 해제한다.
<br/>

## 내가 푼 방식
* 첫 번째: 압축된 문자열을 character 형으로 변환하여 stacak에 push 한다.
* 두 번째: push 도중 ‘)’ 를 만나게 된다면 압축해제 과정을 시작한다.
* 세 번쨰: StrinBuilder에 괄호가 아닐 때 까지 (‘(‘) bulder에 append 해준다.
* 네 번째: 압축과정에서 얼마나 반복됐는지 확인하는데 만약 숫자 값이 아니거나 stack이 비어있을 경우 builder에 저장된 값을 다시 stack에 저장한다. 숫자 값이라면 그 숫자만큼 builder에 string값을 증가 시켜준다.
* 다섯 번째: 압축된 문자열 확인이 끝나면 stack에 있는 값을 string으로 변환하여 출력한다.

<br/>

## 강의
* 첫 번째: 압축된 문자열을 ‘)’ 아닐 때 stack에 push한다.
* 두 번째: ‘)’ 값을 만날 경우 stack을 탐색하는데, stack을 pop 후 ‘(‘ 값이 아니면 tmp에 값을 누적한다.
* 세 번째: pop 한 값이 ‘(‘ 일 경우 stack의 헤더 값이 숫자인지, 괄호인지 확인 후 숫자라면 num에 값을 넣어준다.
* 네 번째: num 만큼 tmp 값을 증가 후 stack에 push 후 종료한다.
* 다섯 번째: 압축된 문자열 확인이 끝나면 stack에 있는 값을 string으로 변환하여 출력한다.


<br/>

## 문제점
제한사항을 제대로 확인하지 않아 문자열의 반복횟수가 0~30인 점을 놓쳐 10 이상인 경우 정답이 나오지않는 상황이 발생했다. 문제를 꼼꼼히 읽어보지 않는 습관을 빨리 고쳐야 할 것 같다.
