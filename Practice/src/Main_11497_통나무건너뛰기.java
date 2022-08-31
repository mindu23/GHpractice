import java.io.*;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {

    static int N, res;
    static int[] wood;
    static boolean[] visit;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            res = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            wood = new int[N];
            visit = new boolean[N];
            list = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                wood[i] = Integer.parseInt(st.nextToken());
            }
            perm(0);
            bw.write(res+"\n");
        }
        bw.flush();
    }

    private static void perm(int cnt) {
        if (cnt == N){
            check();
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (i != 0 && Math.abs(list[i-1]-list[i]) > res) continue;
            visit[i] = true;
            list[cnt] = wood[i];
            perm(cnt+1);
            visit[i] = false;
        }
    }

    private static void check() {
        int diff = 0;
        for (int i = 0; i < N; i++) {
            if (i == N-1) {
                diff = Math.max(diff, Math.abs(list[i] - list[0]));
            }else {
                diff = Math.max(diff, Math.abs(list[i]-list[i+1]));
            }
        }
        res = Math.min(res, diff);
    }
}
