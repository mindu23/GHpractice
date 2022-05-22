package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    스티커 2n개를 구매했다.
    스티커는 2행 n열로 배치되어 있다.
    스티커 한 장을 떼면 변을 공유하는 스티커는 모두 사용할 수 없음
    점수의 합이 최대가 되도록 스티커를 떼어내려고 한다.
    상냥이가 뗄 수 있는 스티커의 점수의 최댓값은?
    즉, 점수의 합이 최대 -> 변을 공유하지 않는 스티커 집합
 */
public class Main_9465_스티커 {

    static int n;
    static int[][] sticker, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            sticker = new int[2][n];
            // [i][j]번째 스티커를 뗐을 때 최대 값
            // [0][0] -> [1][0] -> [0][1] 순서대록
            // 위에서 아래로 오른쪽으로 증가하며
            dp = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            int max = 0;

            if (n == 1){
                max = Math.max(dp[0][0], dp[1][0]);
            }else{
                // n이 1일 경우도 대비해야 한다.
                dp[0][1] = dp[1][0] + sticker[0][1];
                dp[1][1] = dp[0][0] + sticker[1][1];

                max = Math.max(dp[0][1], dp[1][1]);

                for (int i = 2; i < n; i++) {
                    for (int j = 0; j < 2; j++) {
                        // [j][i]번째 스티커를 뗐을 때 최대 값
                        // [j==1?0:1][i-2] 뗏을 때 or [j==1?0:1][i-1]를 뗏을 때

                        dp[j][i] = Math.max(dp[j==1?0:1][i-1] + sticker[j][i], dp[j==1?0:1][i-2] + sticker[j][i]);
                        max = Math.max(max, dp[j][i]);
                    }
                }

            }
            System.out.println(max);
        }
    }
}
