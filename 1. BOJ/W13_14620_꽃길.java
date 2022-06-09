import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W13_14620_꽃길 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        // 한 점을 가운데로 꽃을 심고 심을 수 있는 위치, 가격 담기
        // 가격을 기준으로 정렬
        // 겹치지 않게 3개 선택
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0,0);
        System.out.println(res);
    }

    static class Flower implements Comparable<Flower>{
        int r;
        int c;
        int p;

        public Flower(int r, int c, int p) {
            this.r = r;
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(Flower o) {
            return Integer.compare(this.p, o.p);
        }
    }

    private static void solution(int cnt, int sum){

        if (cnt == 3) {
            res = Math.min(res, sum);
            return ;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check(i, j)){
                    checkV(i, j, true);
                    solution(cnt+1, sum + flower(i, j));
                    checkV(i, j, false);
                }
            }
        }
    }

    private static void checkV(int i, int j, boolean b) {
        for (int d = 0; d < dr.length; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            visited[nr][nc] = b;
        }
    }

    private static boolean check(int i, int j) {

        for (int d = 0; d < dr.length; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) return false;
        }

        return true;
    }

    static int[] dr = {0,-1,0,1,0};
    static int[] dc = {0,0,1,0,-1};
    private static int flower(int i, int j) {
        int p = 0;

        for (int d = 0; d < dr.length; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            p += map[nr][nc];
        }

        return p;
    }
}
