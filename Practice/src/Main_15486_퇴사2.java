import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15486_퇴사2 {

    public static void main(String[] args) throws IOException {
        /**
         * 최대 수익을 구하는 프로그램
         * 뒤에서 부터 헤당 날까지 받을 수 있는 P로 dp
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            String[] cur = br.readLine().split(" ");
            T[i] = Integer.parseInt(cur[0]);
            P[i] = Integer.parseInt(cur[1]);
        }

        // 뒤에서부터 해당 날에 받을 수 있는 수익 더해가기
        int[] dp = new int[N+1];
        for (int i = N-1; i >= 0; i--) {
            if (i + T[i] <= N){
                // 시간 내에 끝낼 수 있다면
                // 끝나는 날 + 해당 상담 P or 그 전
                dp[i] = Math.max(dp[i + T[i]] + P[i], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[0]);
    }
}
