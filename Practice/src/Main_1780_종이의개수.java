import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780_종이의개수 {

    static int N;
    static int minus = 0;
    static int zero = 0;
    static int one = 0;
    static int[][] map;
    static int[] d = {0,1,2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int W = N/3;

        if (N == 1){
            solution(0,0,1);
        }else{
            solution(0, 0, W);
        }
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void solution(int r, int c, int w) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int nr = r + w * d[i];
                int nc = c + w * d[j];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (!check(nr, nc, w)){
                    solution(nr, nc, w/3);
                }
            }
        }
    }

    private static boolean check(int nr, int nc, int w) {
        int minusCnt = 0;
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = nr; i < nr + w; i++) {
            for (int j = nc; j < nc + w; j++) {
                if (map[i][j] == -1) minusCnt++;
                else if (map[i][j] == 0) zeroCnt++;
                else oneCnt++;
            }
        }

        if (oneCnt == w*w) one++;
        else if (zeroCnt == w*w) zero++;
        else if (minusCnt == w*w) minus++;
        else return false;
        return true;
    }
}
