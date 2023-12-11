# [오픈채팅방](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap35/src/Main.java)

오픈채팅방을 관리하는 프로그램을 만드는 문제인데 사용자가 입장하거나 퇴장하면 로그를 쌓는다. ‘Enter’ 는 입장 ‘Leave’ 는 퇴장 ‘Change’ 는 닉네임 변경이다. 여기서 ‘Chnage’로 값이 들어오면 같은 uid에 기록되있는 로그의 닉네임을 모두 변경된 닉네임으로 바꿔여한다. ‘Chnage’가 아니더라도 재입장 시 기존에 쓰던 닉네임이 아닌 다른 닉네임으로 변경시 이것도 모두 변경해줘야한다.<br/>

<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/86fbb09f-52fe-4c2a-909c-2bfa47cbeb6f" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/974c8411-1780-402e-a4e3-ed5816d028fe" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/6f5190f9-157d-48b3-b894-c1efe105e03c" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>

## 해법
* 첫 번째: 먼저 이벤트내역 String 배열 값을 split으로 나눠준다. 그리고 메세지, 닉네임, uid를 저장하는 class를 하나 만든다.
* 두 번째: 사용자가 입장하거나, 닉네임 변경이벤트 일 경우 닉네임 변경 플래그 값을 false로 변경 후 Map에 있는 nickname 값을 최신화 한다. 그리고 유저가 나갈 시 닉네임 정보를 주지 않기 때문에 uid로 nickname을 가져온다.
* 세 번째: 이벤트내역에 맞는 이벤트대로 분기처리한다. 그리고 입장, 퇴장 시 로그 class에 값을 담아 list에 저장하고, 저장된 index 값을 Map에 uid를 key 값으로 잡고 index(list 형태로 저장)를 value에 저장한다.
* 네 번쨰: 닉네임 변경 이벤트가 일어났을 경우 닉네임 변경 함수에 index를 저장하고있는 Map, nickname, 로그정보를 전달해 기존로그 닉네임을 변경한다.



## 문제점
* 첫 번째: 시간 초과가 문제 9개가 발생했다.. 그래서 1차로 닉네임 변경 이벤트가 있을 때 닉네임 변경이 됐는지 확인되면 닉네임 변경 함수를 타도록 변경 했는데 시간 초과문제가 2개만 해결 되 아직도 7개가 남았다.
* 두 번째: 로그의 index 값을 따로 저장하는 map을 추가했는데, 사용자 uid를 key로 기준을 잡고 value를 list 형태로 index를 관리했다. 그리고 닉네임 변경 이벤트가 있을 때 index를 관리하는 map을 넘겨 닉네임을 변경해 줬는데 그 결과 O(n)에서 O(1)로 변경되어 문제를 해결했다.