package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class D17_n제곱배열자르기_87390 {

    public static void main(String[] args) {
        Assertions.assertEquals(Arrays.toString(new int[]{3,2,2,3}), Arrays.toString(solution(3,2,5)));
        Assertions.assertEquals(Arrays.toString(new int[]{4,3,3,3,4,4,4,4}), Arrays.toString(solution(4,7,14)));
    }

    private static int[] solution(int n, long left, long right) {
        long r = right - left + 1;
        int[] answer = new int[(int) r];

//        12 3223 333
//        1234
//        2234
//        3334
//        4444
//        3422
        int idx = 0;
        for (long i = left; i <= right; i++) {
            int nr = (int)(i/n)+1; // 1 1 2 2
            int nc = (int)(i%n)+1; // 3 4 1 2

            answer[idx++] = nr>nc?nr:nc;
        }

        return answer;
    }
}
