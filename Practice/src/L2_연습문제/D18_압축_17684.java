package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class D18_압축_17684 {

    public static void main(String[] args) {
        Assertions.assertEquals(Arrays.toString(new int[]{11,1,27,15}), Arrays.toString(solution("KAKAO")));
        Assertions.assertEquals(Arrays.toString(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}), Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
    }

    /**
     * 무손실 압축 알고리즘 구현하기
     * LZW
     * 1. 길이가 1인 모든 단어 포함해 사전 초기화
     * 2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 찾기
     * 3. w에 해당하는 사전의 색인번호 출랙, w 제거
     * 4. 입력에서 처리되지 않은 다음 글자(c)가 남아있다면 w+c 단어 사전 등록
     * 5. 2-4 반복
     *
     * 영문 대문자만 처리한다.
     * @param msg
     * @return
     */
    private static int[] solution(String msg) {
        int[] answer = {};
        LinkedList<Integer> list = new LinkedList<>();

        // Map<String, Integer> 사전
        Map<String, Integer> map = new HashMap<>();
        int searchIdx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), searchIdx++);
        }

        // 하나씩 돌면서 확인하기 <- 해당 글자가 있으면 다음 인덱스까지 추가해서 사전에 넣기
        int curIdx = 0;
        while(true){
            boolean ck = false;
            String find = "";
            int addIdx = 0;
            for (int i = curIdx+1; i <= msg.length(); i++) {
                find = msg.substring(curIdx, i);
                if (!map.containsKey(find)){
                    map.put(find, searchIdx++);
                    curIdx = i-1;
                    break;
                }else{
                    addIdx = map.get(msg.substring(curIdx, i));
                    if (i == msg.length()) ck = true;
                }
            }
            list.add(addIdx);
            if (ck) break;
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
