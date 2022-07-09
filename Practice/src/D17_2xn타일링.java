public class D17_2xn타일링 {

    public static void main(String[] args) {
        // 가로의 길이 n, 세로의 길이 2
        int sol = solution(4);
        System.out.println(sol);
    }

    /**
     * 하나씩 만들어서 점화식을 구해보자..
     */
    private static int solution(int n) {
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%1000000007;
        }
        return dp[n];
    }
}
