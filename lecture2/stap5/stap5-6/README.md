# [* 최대 인원수](https://github.com/malvr00/Java-algorithm/blob/master/lecture2/stap5/stap5-6/src/Main.java)
현수에게는 1번 역부터 n번 역 사이를 운행하는 어린이용 기차들이 있습니다.<br/> 
모든 기차는 각각 수용인원이 정해져 있고 s번역에서 출발하여 e번 역까지 운행합니다.(s < e)<br/>
모든 기차가 한 번만 운행한다고 가정 했을 때, 현수는 최대한 많은 어린이가 기차를 이용할 수 있도록 예약을 받으려 합니다.<br/>
모든 기차는 같은 역에 도착하는 시간과 출발하는 시간이 동일합니다. 그래서 모든 기차는 모든 역에서 서로 환승이 가능합니다.<br/> 
환승하는 횟수의 제한은 없습니다.<br/>
기차의 최대 수용 인원수를 넘지 않도록, 최대한 많은 어린이의 예약을 받으려 합니다.
<br/>

## 내가 푼 방식
x
<br/>

## 강의
- 기차 정보 trans를 train 배열안에 하나의 기차로 탑승 가능 정보를 넣는다.
  - `train[trans[i][0]] += trains[i][2]`, `train[trans[i][1]] -= trains[i][2]`, `train[i] += train[i - 1]` 
    - 모든 기차는 같은 역에 도착하는 시간과 출발하는 시간이 동일하기 때문이다
- 손님이 탑승하는 정보 bookings 배열을 List 배열에 해당 역을 `Index`로 기준을 잡아서 새롭게 할당한다.
- 1번역부터 마지막역 n 까지 반복문을 돌면서 첫 번째로는 해당역에 내릴 손님을 찾는다. 내릴 손님이 있다면 answer를 1 증가한다.
- 두 번째로는 해당 역에 탑승하는 고객들은 LinkedList에 하차 역 정보만 넣는다. 고객 정보를 다 넣으면 내리는 시간을 기준으로 오름차순 정렬한다.
- 마지막으로 `train['현재 역']`의 탑승 가능 인원과 탑승해 있는 LinkedList 크기를 비교해서 초과했다면 맨 뒤의 손님부터 강제하차를 진행한다.
<br/>

## 문제점
- 처음 내가 접근한 방식은 해당 손님들이 기차에 탑승 했을 때 만약 기차 도착 역이 5번 역이고, 손님이 내려야하는 역은 7번 역 일 경우 기차를 환승하는 부분이 문제가 되었다.
  - 기차를 하나로 통일해 해당 역 마다 탑승가능한 인원을 계산하여 문제를 해결했지만, 위와같은 문제를 해결하는 방안으로 다시 접근해서 문제를 다시 풀어봐야겠다. 
