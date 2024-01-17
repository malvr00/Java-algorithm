# [한 번 사용한 최초문자](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap2/stap2-1/src/Main.java)

String 값에서 중복되지 않은 문자 중 index 번호가 가장 낮은 수를 출력하는 문제이다. 만약 중복되지 않은 문자가 없다면 -1을 출력한다.<br/>

## 내가 푼 방식
* 첫 번째: HashMap에 문자열의 중복된 수를 카운트하여 저장한다.
* 두 번째: HashMap을 기준으로 반복문을 돌면서 값이 1인 문자를 문자열의 indexOf를 활용하여 가장 낮은 index 번호를 저장 후 출력한다


<br/>

## 강의
* 첫 번째: HashMap에 문자열의 중복된 수를 카운트하여 저장한다.
* 두 번째: 문자열을 기준으로 반복문을 돌면서 HashMap의 값이 1일 때 출력한다.

<br/>

## 문제점
IndexOf(O(n))를 활용해 시간 복잡도가 증가한 반면에, 강의에서는 문자열을 기준으로 Map을 탐색해(get -> O(1)) 쓸때없는 탐색을 줄였다.
