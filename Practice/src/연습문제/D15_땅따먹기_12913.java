package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class D15_땅따먹기_12913 {

    public static void main(String[] args) {
//        Assertions.assertEquals(16, solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
        Assertions.assertEquals(34, solution(new int[][]{{1,2,6,7},{2,3,10,8},{1,3,9,4},{7,11,9,4}}));
    }

    private static int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];

        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < land.length; i++){
            // i를 밟기 위해 이전에서 가져온 가장 큰 값 찾기
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    max = Math.max(max, land[i][j] + dp[i-1][k]);
                }
                dp[i][j] = max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length-1][i]);
        }

        return answer;
    }
}
