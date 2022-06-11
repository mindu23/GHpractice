import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W5_1245_농장관리 {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j])
                    flag = true;
                    solution(i, j);
                    if(flag) ans++;
            }
        }
        System.out.println(ans);

    }

    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    private static void solution(int r, int c){

    }
}
