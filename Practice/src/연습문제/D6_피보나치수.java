package 연습문제;

import org.junit.jupiter.api.Assertions;

public class D6_피보나치수 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(3));
        Assertions.assertEquals(5, solution(5));
    }

    private static int solution(int n) {
        int answer = 0;
        dp = new int[100001];
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        }
        answer = dp[n];
        return answer;
    }

    static int[] dp;

}
