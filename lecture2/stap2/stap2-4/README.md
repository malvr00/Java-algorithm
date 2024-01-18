# [음수가 있는 부분수열](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap2/stap2-4/src/Main.java)

nums 배열에 숫자가 주어질 때 m이 될 수 있는 경우의 수 를 구하는 문제이다.
<br/>

## 내가 푼 방식
* 첫 번째: nums를 기준으로 반복문을 돈다.
* 두 번째: sum에 nums[i] 값을 누적한다.
* 세 번째: 값을 누적 후 map에서 ( sum - m )의 key 값이 존재하는지 확인한다.
* 네 번째: 만약 키 값이 존재하다면 answer에 map value 값을 누적한다. <br/>
그 이유는 예를 들어 2, 2, 3의 nums 값이 주어지고 m 이 5 일 때 2를 sum에 값을 누적한다. <br/>
그리고 map에 2를 key로 새롭게 저장한다. <br/>
그 다음 수 2를 sum에 누적해 4로 만들어준다. <br/>
그 후 map에 key 값으로 4 - m가 존재하는지 확인한다. 존재하지 않으므로 비교는 종료되고 map에 4를 key로 새롭게 저장한다. <br/>
다음 수인 3을 sum에 누적해 7로 만들어준다. <br/>
map에 7 - m의 key 값이 존재한지 비교한다. 값이 존재하므로 answer에 map에 7 - m 의 key 값 value를 누적시킨다. <br/>
(sum - m을 key로 만들어서 비교하는 이유는 sum 값이 7일 때 m의 값을 빼주면 2가 되는데 이 2의 값이 map에 존재한다면 7에서 2 까지의 합 한 범위를 빼주면 5가 되기 때문이다. map에 저장되는 key 값은 sum을 구한 범위를 저장하는 것 과 같다.)

<br/>

## 강의
x

<br/>

## 차이점
x
