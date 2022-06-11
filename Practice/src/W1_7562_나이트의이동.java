import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class W1_7562_나이트의이동 {

    static int l, ans;
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int dR = Integer.parseInt(st.nextToken());
            int dC = Integer.parseInt(st.nextToken());
            map[dR][dC] = 2;
            bfs(sR, sC);

            System.out.println(ans);
        }

    }

    private static void bfs(int sR, int sC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[l][l];
        q.offer(new int[]{sR, sC, 0});
        v[sR][sC] = true;

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] a = q.poll();
            int r = a[0], c = a[1];
            cnt = a[2];
            if (map[r][c] == 2) {
                break;
            }

            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= l || nc < 0 || nc >= l || v[nr][nc]) continue;

                q.offer(new int[]{nr, nc, cnt + 1});
                v[nr][nc] = true;
            }
        }
        ans = cnt;
    }
}
