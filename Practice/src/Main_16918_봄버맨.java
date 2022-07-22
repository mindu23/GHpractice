import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16918_봄버맨 {

    static int R, C, N;
    static char[][] map;
    static int[][] bomb;
    static int[] dr = {0,0,0,-1,1};
    static int[] dc = {0,-1,1,0,0};
    // 빈칸 . 폭탄 O
    // 폭탄 설치한지 3초가 지나면 폭발. 연쇄 폭발 X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') bomb[i][j] = 1;
            }
        }
        // 입력 완료


        // N초 동안
        for (int k = 1; k < N; k++) {
            solution(k);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void solution(int k) {
        if (k % 2 == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = 'O';
                        bomb[i][j] = 1;
                    } else if (map[i][j] == 'O') {
                        bomb[i][j]++;
                    }
                }
            }
        }else {
            // 폭탄 시간 증가 및 폭발
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'O') bomb[i][j]++;
                    if (map[i][j] == 'O' && bomb[i][j] >= 3) {
                        for (int d = 0; d < dr.length; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                            if ((i < nr || j < nc) && map[nr][nc] == 'O' && bomb[nr][nc] >= 2) continue;
                            map[nr][nc] = '.';
                            bomb[nr][nc] = 0;
                        }
                    }
                }
            }
        }
    }
}
