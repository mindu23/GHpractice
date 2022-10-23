package L1_연습문제;

import org.junit.jupiter.api.Assertions;

public class 가운데글자가져오기_12903 {

    public static void main(String[] args) {
        Assertions.assertEquals("c", solution("abcde"));
        Assertions.assertEquals("we", solution("qwer"));
    }

    /**
     * 가운데 글자 반환하기
     * 단어의 길이가 짝수라면 가운데 두글자 <- String
     * @param s
     * @return
     */
    private static String solution(String s) {
        String answer = "";
        int len = s.length();
        // 짝수
        if (len%2==0){
            answer = s.substring((len/2)-1, (len/2)+1);
        }else {
            // 홀수
            answer = String.valueOf(s.charAt(len/2));
        }
        return answer;
    }
}
