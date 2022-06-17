import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2631_줄세우기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }

        // 가장 긴 오름차순 길이를 구하고 LIS(longest increasing subsequence)
        // N - LIS

        solution(N, children);
    }

    private static void solution(int n, int[] children) {
        // i를 끝으로하는 최장증가수열 길이
        int[] dp = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            // 나를 포함하지 않는 아이들 중에 가장 긴 길이를 구하라
            for (int j = 0; j < i; j++) {
                if (children[j] < children[i] ) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);
    }
}
