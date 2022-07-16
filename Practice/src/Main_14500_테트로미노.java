import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

    static int N, M, max, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Integer.max(max, map[i][j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                solution(i, j, 1, map[i][j], visited);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    private static void solution(int r, int c, int cnt, int sum, boolean[][] visited) {
        if (cnt == 4){
            ans = Integer.max(ans, sum);
            return;
        }
        for (int d = 0; d < dr.length; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
            if (cnt + 1 == 3 && sum + map[nr][nc] + max <= ans) continue;
            visited[nr][nc] = true;
            solution(nr, nc, cnt + 1, sum + map[nr][nc], visited);
            visited[nr][nc] = false;
            if (cnt + 1 == 2) solution(nr, nc, cnt + 1, sum + map[nr][nc], visited, d>=2?0:2);
        }
    }

    private static void solution(int r, int c, int cnt, int sum, boolean[][] visited, int n) {
        if (r+dr[n] < 0 || r+dr[n] >= N || c+dc[n] < 0 || c+dc[n] >= M) return;
        if (r+dr[n+1] < 0 || r+dr[n+1] >= N || c+dc[n+1] < 0 || c+dc[n+1] >= M) return;
        ans = Integer.max(ans, sum + map[r+dr[n]][c+dc[n]] + map[r+dr[n+1]][c+dc[n+1]]);
    }
}
