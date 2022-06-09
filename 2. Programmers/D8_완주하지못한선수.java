package study;

import java.util.HashMap;
import java.util.Set;

public class D8_완주하지못한선수 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String solution = solution(participant, completion);
        System.out.println(solution);
    }

    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> m = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            // 하나씩 확인 하기
            if(m.containsKey(participant[i])){
                int k = m.get(participant[i]);
                // 값 변경하기
                m.replace(participant[i], k+1);
            }else {
                m.put(participant[i], 1);
            }
        }

        for (String s : completion) {
            if(m.containsKey(s)){
                int k = m.get(s);
                if(k == 1){
                    m.remove(s);
                }else{
                    m.replace(s,k-1);
                }
            }
        }

        // 마지막 남은..
        Set<String> ans = m.keySet();
        answer = (String) (ans.toArray()[0]);
        return answer;
    }
}
