package DP1;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2407_조합 {

    // 5C2 -> (5 * 4) * (3 * 2 * 1) / (3 * 2 * 1) * (2 * 1)
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new BigInteger[n+1];
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }

        if (n == m){
            System.out.println(1);
        }else{
            BigInteger result = dp[n].divide(dp[n - m].multiply(dp[m]));
//            double result = dp[n] / (dp[n-m] * dp[m]);
            System.out.print(result);
        }
    }
}
