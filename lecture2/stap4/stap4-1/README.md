# [이진수 정렬](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap4/stap4-1/src/Main.java)
매개변수 nums에 숫자가 주어지면 nums의 원소들을 이진수로 변환했을 때 1의 개수가 적은 것부터 많은 것 순으로 정렬하여 반환하는 프로그램을 작성하는 문제이다. 

<br/>

## 내가 푼 방식
- nums의 값이 하나 넘어올 때 `Integer.toBinaryString()` JAVA에서 제공하는 이진수로 바꾸는 메소드를 사용했다.
- 이진수가 구해지면 1을 카운터해 작업이 완료되면 Node를 생성 후 List에 담아 정렬 후 answer를 구했다.

<br/>

## 강의
- nums의 값이 넘어오면 나머지 값은 이진수 값이되고 몫은 다음 이진수를 구하는 값으로 0이 될때 까지 반복한다.
  - 이때 1값이 구해지면 1을 카운터하고 계속 반복한다.
- Arrays.sort()를 사용해 배열 정렬 후 answer를 구했다.


<br/>

## 차이점
- 내가 푼 문제는 JAVA에서 제공하는 메서드로 구했고 강의에서는 직접 계산해서 이진수 값을 구했다.

