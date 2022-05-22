package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    n개의 정수로 이루어진 임의의 수열
    연속된 몇 개의 수를 선택해 구할 수 있는 합 중 가장 큰 합을 구하자
    단, 수는 한개 이상 선택
    숫자 안에 마이너스가 있어도 되겠군
 */
public class Main_1912_연속합 {

    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        // 현재 까지의 수의 선택 합 중 가장 큰 합
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i];

            // 연속된 합을 구해야 하므로 현재 + 이전 > 현재 일때 만 dp를 업데이트 해준다.
            if (dp[i] < dp[i-1]+arr[i]){
                dp[i] = dp[i-1]+arr[i];
            }
            max = dp[i]>max?dp[i]:max;
        }

        System.out.println(max);
    }
}
