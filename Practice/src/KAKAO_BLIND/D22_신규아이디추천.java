package KAKAO_BLIND;

import org.junit.jupiter.api.Assertions;

public class D22_신규아이디추천 {

    public static void main(String[] args) {
        Assertions.assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
    }

    /**
     * 아이디 규칙에 따른 입력된 아이디와 유사하면서 규칙에 맞는 아이디 추천
     * - 아이디 길이는 3자 이상 15자 이하
     * - 알파벳 소문자, 숫자, -, _, . 만 사용할 수 있음
     * - 단 .(마침표)는 처음과 끝에 사용할 수 없으며 연속으로 사용할 수 없다.
     * @param new_id 입력받는 아이디
     * @return 추천 아이디
     */
    private static String solution(String new_id) {
        String answer = new_id;

        answer = answer.toLowerCase();
        // 소문자, 숫자, -, ., _만 살리기
        String pattern = "[^a-z0-9\\-._]";
        answer = answer.replaceAll(pattern, "");

        // .이 여러번 나오면 하나의 .으로 변경
        pattern = "[\\.]+"; //or [\\.]{2,} : 특수문자 .이 2개 이상 있을 경우
        answer = answer.replaceAll(pattern, ".");

        // 처음이나 끝에 있는 .은 삭제
        pattern = "^[\\.]|[\\.]$"; // ^는 처음, $는 문자열 끝을 나타낸다. |는 또는
        answer = answer.replaceAll(pattern, "");

        // 빈 문자열이면 a 대입
        if (answer.length() == 0) answer = "a";

        // 길이가 16 이상이면 15로 자르기, 제거후 마지막에 .이 오면 삭제
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            pattern = "[\\.]$";
            answer = answer.replaceAll(pattern, "");
        }

        // 길이가 2 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
        if (answer.length() <= 2){
            StringBuilder sb = new StringBuilder();
            sb.append(answer);
            char last = answer.charAt(answer.length()-1);
            while(sb.length() < 3){
                sb.append(last);
            }
            answer = sb.toString();
        }

        return answer;
    }
}
