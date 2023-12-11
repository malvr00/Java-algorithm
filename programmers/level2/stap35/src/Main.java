import java.util.*;


class ChatEvent {
    String msg;
    String nickname;
    String uid;

    public ChatEvent(String msg, String nickname, String uid) {
        this.msg = msg;
        this.nickname = nickname;
        this.uid = uid;
    }
}
public class Main {

    /**
     * Level2
     * 오픈채팅방 (KAKAO)
     */
    public List<ChatEvent> nickChange(List<ChatEvent> arr, String nickname, ArrayList<Integer> index) {
        for (Integer x : index) {
            ChatEvent str = arr.get(x);
            str.nickname = nickname;
            arr.set(x, str);
        }
        return arr;
    }

    public String[] solution(String[] record) {
        /*
            Enter:  입장
            Leave:  퇴장
            Change: 닉네임 변경
         */
        final String[] EVENT = {"Enter", "Leave", "Change"};
        String[] answer = {};
        List<ChatEvent> answerList = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();
        HashMap<String, ArrayList<Integer>> insertMap = new HashMap<>();

        int idx = 0;
        for (String s : record) {
            StringBuilder str = new StringBuilder();
            String[] arr = s.split(" ");
            String action = arr[0];
            String uid = arr[1];
            String nickname = "";
            boolean isJoinNick = true;
            if (action.equals(EVENT[1])) {
                nickname = userInfo.get(uid);
            } else {
                nickname = arr[2];
                String tmpNick = userInfo.get(uid);
                if (tmpNick != null && !tmpNick.equals(nickname)) {
                    isJoinNick = false;
                }
                userInfo.put(uid, nickname);
            }

            // EVENT
            if (action.equals(EVENT[0])) {
                // JOIN
                if (answerList.size() > 0 && !isJoinNick) {
                    answerList = nickChange(answerList, nickname, insertMap.get(uid));
                }
                str.append("님이").append(" ").append("들어왔습니다.");
            } else if (action.equals(EVENT[1])) {
                // OUT
                str.append("님이").append(" ").append("나갔습니다.");
            } else if (action.equals(EVENT[2])) {
                // CHANGE
                if (!isJoinNick) {
                    answerList = nickChange(answerList, nickname, insertMap.get(uid));
                }
            }
            // Insert
            if (str.length() > 0) {
                ArrayList<Integer> indexList = insertMap.get(uid);
                if (indexList != null) {
                    indexList.add(idx++);
                    insertMap.put(uid, indexList);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(idx++);
                    insertMap.put(uid, list);
                }
                answerList.add(new ChatEvent(str.toString(), nickname, uid));
            }
            str.setLength(0);
        }

        answer = new String[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i).nickname + answerList.get(i).msg;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*
            record	                                            result
            ["Enter uid1234 Muzi", "Enter uid4567 Prodo",       ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.",
            "Leave uid1234","Enter uid1234 Prodo",              "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
            "Change uid4567 Ryan"]
         */
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        Main main = new Main();
        String[] solution = main.solution(record);

        for (String x : solution) {
            System.out.print(x + " ");
        }
    }
}
