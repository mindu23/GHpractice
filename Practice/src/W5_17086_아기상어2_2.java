import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class W5_17086_아기상어2_2 {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        shark = new boolean[N][M];
        ans = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    shark[i][j] = true;
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            // now[0] : row
            // now[1] : col
            // now[2] : cnt
            for(int d = 0; d < dr.length; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || shark[nr][nc]) continue;
                if(map[nr][nc]!= 0 && map[nr][nc] < now[2]+1) continue;

                map[nr][nc] = now[2]+1;
                if(ans < map[nr][nc]) ans = map[nr][nc];

                q.offer(new int[]{nr, nc, now[2]+1});
            }
        }

        System.out.println(ans);
    }


    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
}
