package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class D3_이진변환반복하기 {

    public static void main(String[] args) {
        Assertions.assertEquals(Arrays.toString(new int[]{3,8}), Arrays.toString(solution("110010101001")));
    }

    /**
     * 1. s의 모든 0제거
     * 2. s의 길이가 c일때, c를 2진법으로 표현한 문자열로 변환
     * s가 1이 될 때까지 계속해서 s에 이진 변환을 반복했을 때,
     * @param s
     * @return new int[] {이진변환의 횟수, 제거된 0의 개수}
     */

    static int zeroCnt = 0;
    static int binaryChangeCnt = 0;
    private static int[] solution(String s) {
        int[] answer = new int[2];

        while(!"1".equals(s)){
            s = removeZero(s);
            System.out.println(s);
            s = binary(s.length());
            System.out.println(s);
        }

        answer[0] = binaryChangeCnt;
        answer[1] = zeroCnt;

        return answer;
    }

    private static String binary(int length) {
        StringBuilder sb = new StringBuilder();
        binaryChangeCnt++;
        while(length > 0){
            int i = length%2;
            sb.append(i);
            length = length/2;
        }
        return sb.reverse().toString();
    }

    private static String removeZero(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zeroCnt++;
        }
        return s.replaceAll("0", "");
    }
}
