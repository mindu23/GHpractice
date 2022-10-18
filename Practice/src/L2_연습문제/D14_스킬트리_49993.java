package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class D14_스킬트리_49993 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    /**
     * 선행스킬 순서를 따라가야 한다. 이외의 것들은 어디나 들어가도 된다.
     * ex) 스파크 -> 라이트닝 볼트 -> 썬더
     * @param skill 선행 스킬 순서
     * @param skill_trees  스킬트리들
     * @return 가능한 스킬트리 개수
     *
     * 모두 달파벳 대문자
     * CBD == C -> B -> D
     * 중복없음
     */
    static int pro = 1;
    private static int solution(String skill, String[] skill_trees) {
        System.out.println("problem: "+pro++);
        int answer = 0;
        // 1. hash로 skill 순서 정하기
        HashMap<String, Integer> hm = new HashMap<>();
        int skillNum = 1;
        for(String sk : skill.split("")){
            hm.put(sk, skillNum++);
        }

        // 2. 해당 스킬트리가 순서에 맞는지 확인
        for(String skillTree : skill_trees){
            int maxNum = 0;
            boolean ck = true;
            for (String sk : skillTree.split("")) {
                // 없다면 순서 상관X
                if (!hm.containsKey(sk)) continue;
                if (hm.get(sk) < maxNum || hm.get(sk) != maxNum+1) {
                    ck = false;
                    break;
                }
                else maxNum = hm.get(sk);
            }
            if (ck) answer++;
        }
        return answer;
    }
}
