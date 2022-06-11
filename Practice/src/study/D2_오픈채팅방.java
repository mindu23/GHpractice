package study;

import java.util.*;

public class D2_오픈채팅방 {

    /**
     * 누군가 오픈채팅방에 들어오면 "[닉네임]님이 들어왔습니다." 출력
     * 나가면 "[닉네임]님이 나갔습니다." 출력
     *
     * 닉네임 변경 방법은
     * 1. 채팅방 나간 후, 새로운 닉네임으로 입장
     * 2. 채팅방에서 닉네임 변경
     * => 닉네임 변경 시 기존 채팅방에 출력된 메시지의 닉네임 전부 변경.
     * 중복 닉네임을 허용한다.
     *
     * 사용자는 유저 아이디로 구분한다.
     *
     */

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] ans = solution(record);

        System.out.println(Arrays.toString(ans));
    }

    public static String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> id_nickname = new HashMap<>();
        ArrayList<String> userId = new ArrayList<>();
        ArrayList<String> command = new ArrayList<>();

        for (int i = 0; i < record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String user_id = st.nextToken();

            if(cmd.startsWith("E")){
                String nickname = st.nextToken();
                id_nickname.put(user_id, nickname);
                userId.add(user_id);
                command.add("님이 들어왔습니다.");
            }else if(cmd.startsWith("L")){
                userId.add(user_id);
                command.add("님이 나갔습니다.");
            }else {// Change
                String nickname = st.nextToken();
                id_nickname.replace(user_id, nickname);
            }
        }

        answer = new String[userId.size()];
        for (int j = 0; j < answer.length; j++){
            StringBuilder sb = new StringBuilder();
            sb.append(id_nickname.get(userId.get(j)));
            sb.append(command.get(j));
            answer[j] = sb.toString();
        }

        return answer;
    }
}
