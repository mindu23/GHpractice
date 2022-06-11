import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class W1_4963_섬의개수 {
    /**
     * 걸어다닐 수 있는 섬의 개수
     * 1은 땅, 0은 바다
     * 가로,세로,대각선 갈 수 있음
     */
    static int W, H, ans;
    static int[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            ans = 0;
            if(W == 0 && H == 0) break;

            map = new int[H][W];
            v = new boolean[H][W];
            for(int h = 0; h < H; h++){
                st = new StringTokenizer(br.readLine());
                for(int w = 0; w < W; w++){
                    map[h][w] = Integer.parseInt(st.nextToken());
                }
            }

            for(int h = 0; h < H; h++){
                for(int w = 0; w < W; w++){
                    if(v[h][w] || map[h][w] == 0) continue;
                    bfs(h,w);
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    static int[] dr = {-1,-1,-1,0,1,1,1,0};
    static int[] dc = {-1,0,1,1,1,0,-1,-1};
    private static void bfs(int h, int w) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{h,w});
        v[h][w] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for(int d = 0; d < dr.length; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 0 || v[nr][nc]) continue;

                q.offer(new int[]{nr, nc});
                v[nr][nc] = true;
            }
        }
    }
}
