# [이모티콘 할인행사(KAKAO)](https://github.com/malvr00/Java-algorithm/blob/master/programmers/level2/stap9/src/Main.java)

이모티콘 플러스 서비스 가입자를 최대의 값을 기준으로 이모티콘 플러스 가입한 인원과 이모티콘 구입한 최대 값을 구하는 문제이다.<br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/83db39bd-b707-449f-9926-a1dc5faa8d6d" width="600px" height="300px" 
  title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/bf3b3256-a079-4797-95a8-7fb2685edfd4" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
<img src="https://github.com/malvr00/Java-algorithm/assets/77275513/fa1265a9-5095-4b65-b045-5cc2edd10fed" width="600px" height="300px"
title="100px" alt="RubberDuck"></img><br/>
  
## 해법
* 첫 번째: 사용자의 원하는 할인율에 부합할 경우 부합한 이모티콘을 구입하고, 이모티콘을 구입하는 도중 사용자가 정한 금액의 기준을 넘어가게 되면 <br/> 
  이모티콘을 구매하지 않고 이모티콘 플러스 서비스를 가입한다. 여기서 파악된 내용은 할인율을 기준으로 이모티콘을 구입 한 다는것을 알 수 있으므로 <br/> 
  기준을 할인율을 잡고 DFS를 활용했다(이모티콘 값이 담겨있는 배열의 최대값이 7인 것도 DFS를 선택한 이유 중 하나). <br/>
* 두 번째: 이모티콘 값이 담겨있는 배열 길이만큼 레벨을 돌고, saleCh 배열에 할인율을 저장해 나갔다. <br/>
* 세 번째: 마지막 레벨에 도달하면, 모든 유저 대상으로 1차로 할인율을 비교하고 2차로 할인율이 사용자 기준에 부합하다면 할인율 만큼 <br/>
  이모티콘 값을 뺀 후 더해준다. 더해준 값이 이모티콘 최대 값 기준을 넘어가면 이모티콘 플러스 서비스 가입자의 카운트를 증가한다. <br/>




## 문제점
* 첫 번째: 체크 배열을 price, sale 두 개를 가지고 진행했는데, 기준을 할인율과 금액을 동시에 체크 후 진행 한 결과 시간초과가 발생했다. 
  쓸모없는 for문이 각 항에 하나씩 추가되어 생긴 문제같다.
* 두 번째: 체크 배열을 sale만 남겨 둔 후 할인율만 가지고 진행되도록 수정했다. 
  그 이전에는 DFS 진입하는 구간에 이모티콘 값이 있는 배열 for문 , 사용자가 이모티콘을 구매하는 구간에는 할인율을 체크하는 for문 추가로 더 있었다. <br/><br/>
첫 번째
```json
{
      if(lv == emoticons.length) {
        int newRegi = 0;
        int price = 0;
        for (int i = 0; i < users.length; i++) {
          int sum = 0;
          for (int j = 0; j < saleCh.length; j++) {
              for (int s = 4; s > 0; s--) {
              if (saleCh[j][s - 1] > 0) {
                int num = s * 10;
                if (num >= users[i][0]) {
                  sum += emoticons[j] - (emoticons[j] * num / 100);
                }
                break;
              }
            }
          }
          if (sum >= users[i][1]) {
            newRegi++;
          } else {
            price += sum;
          }
        }
        if (answer[0] < newRegi) {
          answer[0] = newRegi;
          answer[1] = price;
        } else if (answer[0] == newRegi) {
          answer[1] = Math.max(answer[1], price);
        }
      } else {
        for (int i = 4; i > 0; i--) {
          for (int j = 0; j < emoticons.length; j++) {
            if (priceCh[j] == 0 && saleCh[j][i - 1] == 0) {
              priceCh[j] = 1;
              saleCh[j][i - 1] = 1;
              DFS(users, emoticons, lv + 1);
              priceCh[j] = 0;
              saleCh[j][i - 1] = 0;
            }
          }
        }
      }
}
```
두 번째
```json
{
    if(lv == emoticons.length) {
      int newRegi = 0;
      int price = 0;
      for (int i = 0; i < users.length; i++) {
        int sum = 0;
        for (int j = 0; j < emoticons.length; j++) {
          int num = saleCh2[j] * 10;
          if (num >= users[i][0]) {
            sum += emoticons[j] - (emoticons[j] * num / 100);
          }
        }
        if (sum >= users[i][1]) {
          newRegi++;
        } else {
          price += sum;
        }
      }
      if (answer[0] < newRegi) {
        answer[0] = newRegi;
        answer[1] = price;
      } else if (answer[0] == newRegi) {
        answer[1] = Math.max(answer[1], price);
      }
    } else {
      for (int i = 4; i > 0; i--) {
        saleCh2[lv] = i;
        DFS(users, emoticons, lv + 1);
        saleCh2[lv] = 0;
      }
    }
}
```