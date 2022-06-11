package DP1;

import java.util.Scanner;

public class Main_1463 {

    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        ans = Integer.MAX_VALUE;

//        makeOne(X, 0);

        // DP로 풀기
        int[] dp = new int[X+1];
        dp[1] = 0;
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i-1]+1;
            if (i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        ans = dp[X];
        System.out.println(ans);
    }

    private static void makeOne(int x, int cnt) {
        if (x == 1) {
            ans = cnt;
            return;
        }

        if(x%3==0) {
            if (cnt+1 < ans) makeOne(x/3, cnt+1);
        }

        if(x%2==0) {
            if (cnt+1 < ans) makeOne(x/2, cnt+1);
        }

        if (cnt+1 < ans) makeOne(x-1, cnt+1);
    }
}
