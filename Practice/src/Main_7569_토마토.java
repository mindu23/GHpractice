import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

    static class Tomato {
        int h;
        int n;
        int m;
        int d;

        public Tomato(int h, int n, int m, int d) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.d = d;
        }
    }
    static int M, N, H, ans;
    static int[][][] tomato;
    static int[] dh = {-1, 1};
    static int[] dn = {-1, 1, 0, 0};
    static int[] dm = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        Queue<Tomato> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomato[h][n][m] == 1)
                        q.offer(new Tomato(h, n, m, 0));
                }
            }
        }

        while (!q.isEmpty()){
            Tomato cur = q.poll();
            ans = Integer.max(ans, cur.d);
            for (int d = 0; d < dn.length; d++) {
                int nn = cur.n + dn[d];
                int nm = cur.m + dm[d];
                if (nn < 0 || nn >= N || nm < 0 || nm >= M || tomato[cur.h][nn][nm] == -1 || tomato[cur.h][nn][nm] == 1) continue;
                if (tomato[cur.h][nn][nm] == 0) {
                    tomato[cur.h][nn][nm] = 1;
                    q.offer(new Tomato(cur.h, nn, nm, cur.d + 1));
                }
            }
            for (int h = 0; h < dh.length; h++) {
                int nh = cur.h + dh[h];
                if (nh < 0 || nh >= H || tomato[nh][cur.n][cur.m] == -1) continue;
                if (tomato[nh][cur.n][cur.m] == 0) {
                    tomato[nh][cur.n][cur.m] = 1;
                    q.offer(new Tomato(nh, cur.n, cur.m, cur.d + 1));
                }
            }
        }

        if (!check()) System.out.println(-1);
        else System.out.println(ans);
    }

    private static boolean check() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomato[h][n][m] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
