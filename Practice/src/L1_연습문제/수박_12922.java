package L1_연습문제;

import org.junit.jupiter.api.Assertions;

public class 수박_12922 {

    public static void main(String[] args) {
        Assertions.assertEquals("수박수", solution(3));
        Assertions.assertEquals("수박수박", solution(4));
    }

    private static String solution(int n) {
        // 패턴 반복
        char[] pattern = {'수','박'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(pattern[i%2]);
        }
        return sb.toString();
    }
}
