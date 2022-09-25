package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;

public class D8_영어끝말잇기 {

    public static void main(String[] args) {
        Assertions.assertEquals(Arrays.toString(new int[]{3,3}), Arrays.toString(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        Assertions.assertEquals(Arrays.toString(new int[]{1,3}), Arrays.toString(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }

    /**
     * q 사용, 한번 나온 단어는 쓰면 안됨. HashSet
     * @param n 인원 수
     * @param words 나온 단어 순서대로
     * @return [가장 먼저 탈락하는 사람, 자신의 몇 번째 차례에 탈락하는지]
     */
    private static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        char endChar = words[0].charAt(words[0].length()-1);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != endChar || hs.contains(words[i])){
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }else{
                hs.add(words[i]);
                endChar = words[i].charAt(words[i].length()-1);
            }
        }

        return answer;
    }
}
