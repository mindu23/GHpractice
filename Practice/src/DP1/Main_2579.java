package DP1;

import java.util.Scanner;

public class Main_2579 {

    static int N;
    static int[] stair, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stair = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            stair[i] = sc.nextInt();
        }

        // 한칸 혹은 두칸 올라갈 수 있다.
        // 연속된 세개의 계단을 모두 밟을 수는 없다.
        // 마지막 도착 계단에 멈춰야한다.

        // 밟은 수 있는 최댓값 구하기
        dp[1] = stair[1];
        if (N >= 2)
            dp[2] = stair[2] + dp[1];

        if (N >= 3)
            dp[3] = Math.max(stair[2]+stair[3], dp[1] + stair[3]);

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
        }

        System.out.println(dp[N]);
    }
}
