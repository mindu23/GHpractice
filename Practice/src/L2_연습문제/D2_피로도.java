package L2_연습문제;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class D2_피로도 {

    @Test
    public static void main(String[] args) {
        Assertions.assertEquals(3, solution(80, new int[][]{{80,20},{50,40},{30,10}}));
    }

    /**
     * 일정 피로도를 사용해 던전 탐색
     * @param k 현재 피로도
     * @param dungeons 최소 필요 피로도, 소모 피로도
     * @return 유저가 탐험할 수 있는 최대 던전 수
     */
    private static int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        ans = 0;

        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            go(k-dungeons[i][1], dungeons, visited, 1);
            visited[i] = false;
        }

        return ans;
    }

    static int ans;

    private static void go(int k, int[][] dungeons, boolean[] visited, int cnt) {
        ans = Math.max(ans, cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || k < dungeons[i][0]) continue;
            visited[i] = true;
            go(k - dungeons[i][1], dungeons, visited, cnt + 1);
            visited[i] = false;
        }
    }
}
