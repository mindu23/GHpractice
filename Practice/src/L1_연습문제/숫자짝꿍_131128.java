package L1_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 숫자짝꿍_131128 {

    public static void main(String[] args) {
        Assertions.assertEquals("-1", solution("100", "2345"));
        Assertions.assertEquals("0",
                solution("100", "203045"));
        Assertions.assertEquals("10", solution("100", "123450"));
        Assertions.assertEquals("321", solution("12321", "42531"));
        Assertions.assertEquals("552", solution("5525", "1255"));
    }

    /**
     * X와 Y에서 공통으로 나타나는 정수로 만들 수 있는 가장 큰 정수
     * 존재하지 않으면 -1
     * 짝꿍이 0으로만 이뤄져 있다면 0
     * @param X
     * @param Y
     * @return 큰 정수일 수 있어서 문자열 반환 long
     */
    private static String solution1(String X, String Y) {
        String answer = "";
        LinkedList<Integer> list = new LinkedList<>();

        // 같은 수 계속해서 리스트에 넣기 contains, replaceFirst
        for (int i = 0; i < X.length(); i++) {
            String cur = String.valueOf(X.charAt(i));
            if(Y.contains(cur)){
                Y = Y.replaceFirst(cur, "");
                list.add(Integer.parseInt(cur));
            }
        }

        // 리스트 정렬
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i));
            if (list.get(i) != 0) zero = false;
        }

        if (list.size() == 0) return "-1";
        if (zero) return "0";

        // 문자열로 반환
        return sb.toString();
    } // 시간초과

    private static String solution(String X, String Y) {
        String answer = "";
        // 숫자, 카운트
        Map<Integer, Integer> map = new HashMap<>();
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        // X의 자리수
        check(arrX, X);
        // Y의 자리수
        check(arrY, Y);

        // 작은 값이 결과
        int[] arr = new int[10];
        res(arr, arrX, arrY);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            int cnt = arr[i];
            for (int j = 0; j < cnt; j++) {
                sb.append(i);
            }
        }

        if (sb.toString().length() == 0) return "-1";
        if (sb.toString().startsWith("0")) return "0";

        // 문자열로 반환
        return sb.toString();
    }

    private static void res(int[] arr, int[] arrX, int[] arrY) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrX[i] > arrY[i] ? arrY[i] : arrX[i];
        }
    }

    private static void check(int[] arr, String s) {
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            arr[n]++;
        }
    }
}
