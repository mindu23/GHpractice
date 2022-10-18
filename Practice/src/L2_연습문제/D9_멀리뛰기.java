package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class D9_멀리뛰기 {

    public static void main(String[] args) {
        Assertions.assertEquals(solution(4), 5);
        Assertions.assertEquals(solution(3), 3);
        Assertions.assertEquals(solution(1), 1);
    }

    private static long solution(int n) {
        long answer = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n > 1) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        return dp[n];
    }
}
