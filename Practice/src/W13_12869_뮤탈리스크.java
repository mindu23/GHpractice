import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W13_12869_뮤탈리스크 {

    static int N, min;
    static int[] scv;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j][k]는 체력이 i, j, k일 때, 모두 파괴하는 최소 공격 횟수
        // 공격할 수 있는 횟수: 6가지

        dp = new int[61][61][61];
        min = Integer.MAX_VALUE;

        solution(scv, 0);
        System.out.println(min);

    }

    static int[][] attack = {{-9, -3, -1}, {-9, -1, -3}, {-3, -1, -9}, {-3, -9, -1}, {-1, -9, -3}, {-1, -3, -9}};
    private static void solution(int[] scv, int cnt) {
        int s0 = scv[0];
        int s1 = scv[1];
        int s2 = scv[2];

        // 실행 횟수가 더 그다면 실행할 필요 없음
        if (cnt >= min) return;

        // 이미 방문했는데 기존 공격 횟수가 더 작을 경우 중단
        if (dp[s0][s1][s2] != 0 && dp[s0][s1][s2] <= cnt) return;

        // s0, s1, s2가 되기 까지 최소 공격 횟수
        dp[s0][s1][s2] = cnt;

        if (s0 == 0 && s1 ==0 && s2 ==0){
            min = Math.min(min, cnt);
            return ;
        }

        for (int i = 0; i < attack.length; i++) {
            solution(new int[]{Math.max(s0+attack[i][0], 0), Math.max(s1+attack[i][1],0), Math.max(s2+attack[i][2],0)}, cnt+1);
        }
    }
}
