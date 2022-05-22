package DP1;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

    static int[] A, dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        // 현재까지 증가 부분 수열의 최장 길이
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        // 입력받은 수
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        // A 수열을 하나씩 증가하며 진행한다,
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 나 하나 포함해 놓기

            // i보다 작은 값까지의 증가 부분 수열 구하기
            for (int j = 0; j < i; j++) {
                // 만약 현재 값보다 작다 && 현재 나의 길이보다 전 길이+1이 크다 == 업데이트 해준다.
                if (A[j] < A[i] && dp[i] < dp[j]+1)
                    dp[i] = dp[j]+1;
            }
            // max값으로 dp 값 중 가장 큰 값이 필요하기 때문
            if (max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}
