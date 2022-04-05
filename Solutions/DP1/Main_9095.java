package DP1;

import java.util.Scanner;

public class Main_9095 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            dp[1] = 1;

            for (int i = 2; i <= n ; i++) {
                if (i == 2){
                   dp[i] = 2;
                   continue;
                }
                if (i == 3) {
                    dp[i] = 4;
                    continue;
                }
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
