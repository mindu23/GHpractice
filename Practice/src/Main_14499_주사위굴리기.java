import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[][] dice;
    static int[] d;
    static int[] dr = {0,0,0,-1,1};//우 좌 상 하
    static int[] dc = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dice = new int[][]
                {{0, 2, 0},
                {4, 1, 3},
                {0, 5, 0},
                {0, 6, 0}}; // 맨 위는 1,1 맨 아래는 3,1

        d = new int[7];
        d[6] = map[x][y];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            move(Integer.parseInt(st.nextToken()));
        }

    }

    private static void move(int command) {
        int nr = x + dr[command];
        int nc = y + dc[command];
        // 벗어나면 무시
        if (nr < 0 || nr >= N || nc < 0 || nc >= M) return ;

        x = nr;
        y = nc;

        int tmp;
        int tmp2;
        switch (command){
            case 1:
                // 오른쪽으로 밀기
                tmp = dice[1][2];
                for (int i = dice[0].length-2; i >= 0; i--) {
                    dice[1][i+1] = dice[1][i];
                }
                dice[1][0] = dice[3][1];
                dice[3][1] = tmp;
                break;
            case 2:
                // 왼쪽으로 밀기
                tmp = dice[1][0];
                for (int i = 1; i < dice[0].length; i++) {
                    dice[1][i-1] = dice[1][i];
                }
                dice[1][2] = dice[3][1];
                dice[3][1] = tmp;
                break;
            case 3:
                // 위로 밀기
                tmp = dice[0][1];
                for (int i = 1; i < dice.length; i++) {
                    dice[i-1][1] = dice[i][1];
                }
                dice[3][1] = tmp;
                break;
            case 4:
                // 아래로 밀기
                tmp = dice[3][1];
                for (int i = dice.length-2; i >= 0; i--) {
                    dice[i+1][1] = dice[i][1];
                }
                dice[0][1] = tmp;
                break;
        }

        // 맨 위는 1,1 맨 아래는 3,1
        if (map[x][y] == 0){
            map[x][y] = d[dice[3][1]];
        }else {
            d[dice[3][1]] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(d[dice[1][1]]);

    }
}
