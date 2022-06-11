package BOJ_24K;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * DP 문제풀이
 */
public class Main_15486 {

    static class E{
        private int s;
        private int t;
        private int p;

        public E(int s, int t, int p) {
            // 시작일
            this.s = s;
            // 기간
            this.t = t;
            // 금액
            this.p = p;
        }
    }

    static int N;
    static int[] dp;
    static E[] tp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        dp = new int[N+2];
        tp = new E[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tp[i] = new E(i, t, p);
        }

        // 맨 끝부터 시작한다.
        for (int i = N; i > 0; i--) {
            // 그날 하루에 끝낼 수 있는 경우 N+1
            if (tp[i].s + tp[i].t > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                // 해당 날짜를 선택하지 않거나 선택하거나
                dp[i] = Math.max(dp[i + 1], dp[tp[i].s + tp[i].t] + tp[i].p);
            }
        }

        System.out.println(dp[1]);
    }

}
