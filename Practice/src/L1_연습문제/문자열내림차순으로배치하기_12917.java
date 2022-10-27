package L1_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 문자열내림차순으로배치하기_12917 {

    public static void main(String[] args) {
        Assertions.assertEquals("gfedcbZ", solution("Zbcdefg"));
    }

    public static String solution(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        StringBuilder sb = new StringBuilder(new String(cArr));

        return sb.reverse().toString();
    }
}
