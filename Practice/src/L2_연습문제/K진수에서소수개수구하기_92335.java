package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class K진수에서소수개수구하기_92335 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, solution(437674, 3));
        Assertions.assertEquals(2, solution(110011, 10));
        Assertions.assertEquals(0, solution(1, 10));
    }

    /**
     * 양의 정수 n을 k진수로 바꿨을 때, 조건에 맞는 소수(Prime number)의 개수 구하기
     * 1. 0P0 처럼 소수 양쪽에 0이 있는 경우
     * 2. P0처럼 소수 오른쪽에만 0, 왼쪽엔 아무것도 없음
     * 3. 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없음
     * 4. P처럼 소수 양쪽에 아무것도 없는 경우
     * 5. P는 각 자리수에 0을 포함하지 않는 소수
     * 예) 101은 P가 될 수 없음
     * 10진법으로 봤을 때, 소수여야함
     * @param n
     * @param k
     * @return
     */
    private static int solution(int n, int k) {
        int answer = 0;
        // n을 k 진수로 변경
        StringBuilder sb = new StringBuilder();
        while (n > 0){
            int r = n%k;
            sb.append(r);
            n = n/k;
        }
        String kNum = sb.reverse().toString();

        // 0으로 split
        String[] split = kNum.split("0");

        // 나온 숫자 10진수로 바꿔서 소수인 경우 개수 구하기
        for(String m : split){
            if (m.isBlank()) continue;
            if(check(m, k)) answer++;
        }

        return answer;
    }

    private static boolean check(String m, int k) {
        long n = Long.parseLong(m);
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
