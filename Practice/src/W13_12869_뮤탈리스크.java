import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W13_12869_뮤탈리스크 {

    static int N;
    static int[] scv;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scv = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 scv를 파괴하기 위한 공격 횟수의 최솟값.
        // 체력이 제일 높은 순서대로 공격하기
        // queue

        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.copyOf(scv, scv.length);
            boolean[] v = new boolean[N];
            for (int j = 0; j < attack.length; j++) {
                v[j] = true;
                solution(i, 0, temp, 0, v);
            }
        }

    }

    static int[] attack = {9,3,1};
    private static void solution(int n, int cnt, int[] temp, int die, boolean[] v) {
        if (temp[n] == 0) return;
        if (die == N) {
            res = Math.min(res, cnt);
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;

        }
    }
}
