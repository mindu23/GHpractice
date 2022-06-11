import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * NxM 크기의 사무실, 총 K개의 CCTV. CCTV는 총 5가지 종류
 * 한쪽, 양쪽, 직각, 세방면, 네방면
 * 감시할 수 있는 방향의 전체 칸을 감시할 수 있다. 벽은 통과하지 못한다.
 * CCTV는 회전시킬 수 있으며 90도 씩 움직인다.
 * 0은 빈칸, 6은 벽, 1~5는 CCTV
 * 사각지대의 최소 크기를 구하여라
 * 1-4번 돌릴 수 있음
 * 2-2번
 * 3-4번
 * 4-4번
 * 5-1번
 *
 * 모두 4번으로 맞춰주자
 *
 * 바뀔 수 있는 모든 방향을 검사해야 한다.
 */

public class W4_15683_감시 {

    static int N, M, ans;
    static int[][] map;
    static List<int[]> cctv;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctv = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if(k != 0 && k != 6){
                    cctv.add(new int[]{i, j, k});
                }
            }
        }

        dir(0); //하우상좌

        System.out.println(ans);
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1}; // 하우상좌

    static void dir(int k){

        if(k == cctv.size()){
            check();
            return;
        }

        for(int i = k; i < cctv.size(); i++){
            int[] C = cctv.get(i);

            if(C[2] == 1){
                watchD(C);
                dir(k+1);
                watchR(C);
                dir(k+1);
                watchU(C);
                dir(k+1);
                watchL(C);
                dir(k+1);
            }else if(C[2] == 2){
                watchD(C);
                watchU(C);
                dir(k+1);
                watchR(C);
                watchL(C);
                dir(k+1);
            }else if(C[2] == 3){
                watchD(C);
                watchR(C);
                dir(k+1);
                watchD(C);
                watchL(C);
                dir(k+1);
                watchU(C);
                watchL(C);
                dir(k+1);
                watchU(C);
                watchR(C);
                dir(k+1);
            }else if(C[2] == 4){
                watchD(C);
                watchR(C);
                watchU(C);
                dir(k+1);
                watchD(C);
                watchL(C);
                watchU(C);
                dir(k+1);
                watchL(C);
                watchU(C);
                watchR(C);
                dir(k+1);
                watchL(C);
                watchD(C);
                watchR(C);
                dir(k+1);
            }else{
                watchD(C);
                watchR(C);
                watchU(C);
                watchL(C);
                dir(k+1);
            }
        }

    }

    static void watchD(int[] C){
        int r = C[0];
        int c = C[1];
        int k = 0;

        while(true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;

            map[nr][nc] = C[2] + 6;
            r = nr;
            c = nc;
        }
    }

    static void watchR(int[] C){
        int r = C[0];
        int c = C[1];
        int k = 1;

        while(true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;

            map[nr][nc] = C[2] + 6;
            r = nr;
            c = nc;
        }
    }

    static void watchU(int[] C){
        int r = C[0];
        int c = C[1];
        int k = 2;

        while(true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;

            map[nr][nc] = C[2] + 6;
            r = nr;
            c = nc;
        }
    }

    static void watchL(int[] C){
        int r = C[0];
        int c = C[1];
        int k = 3;

        while(true) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 6) break;

            map[nr][nc] = C[2] + 6;
            r = nr;
            c = nc;
        }
    }

    static void check() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
                if (map[i][j] > 6) map[i][j] = 0;
            }
        }
        if(ans > cnt) ans = cnt;
    }
}
