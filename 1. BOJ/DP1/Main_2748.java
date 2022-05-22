package DP1;

import java.util.Scanner;

public class Main_2748 {

    static int N;
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
