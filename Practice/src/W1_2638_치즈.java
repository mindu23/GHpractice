import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class W1_2638_치즈 {
    /**
     * 상하좌우 살펴서 두군데 이상 비어있으면 1시간 후 사라진다.
     */

    static int N, M, ans, ch;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
                if(map[n][m] == 1) ch++;
            }
        }

        int cnt = 0;
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                //외부공기
                if(map[n][m] == 0 || !v[n][m])
                    map[n][m] = 3;
                // 안녹은 치즈
                if(map[n][m] == 0 || v[n][m]) continue;
                bfs(n, m, cnt);
            }
        }
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    private static void bfs(int n, int m, int cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n, m, cnt});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], k = cur[2];

            for(int d = 0; d < dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || v[nr][nc]) continue;
                // 주변에 3이 두번이라면 녹을 수 있다.
                int th = 0;
                for(int dd = 0; dd < dr.length; dd++){
                    int kr = nr + dr[dd];
                    int kc = nc + dc[dd];
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[kr][kc] == 3 && !v[kr][kc]){

                    }
                }

            }
        }
    }
}
