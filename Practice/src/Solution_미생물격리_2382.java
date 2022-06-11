import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_미생물격리_2382 {

    static class Micro implements Comparable<Micro> {
        private int r;
        private int c;
        private int cnt;
        private int dir;

        public Micro(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Micro o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }

    static int N, M, K;
    static int[] dr = {0,-1,1,0,0};
    static int[] dc = {0,0,0,-1,1};
    static PriorityQueue<Micro> pq; // 미생물 개수가 큰 순서대로 실행해 준다.
    static Micro map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new Micro[N][N]; // 매 시간마다 각 셀에 이동한 미샐물 정보
            pq = new PriorityQueue<>(); // 살아있는 미생물을 담고있는 pq. 최대 힙

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                pq.offer(new Micro(r, c, cnt, dir));
            }

            System.out.println("#"+t+" "+move());
        }
    }

    private static int move() { // 주어진 M 시간동안 미생물 이동 처리
        int time = M;
        int nr, nc, remainCnt = 0;

        while(time-- > 0){
            // 군집리스트에서 군집들을 하나씩 모두 꺼내어 처리리
            Micro m;
            while (!pq.isEmpty()){
                m = pq.poll();

                nr = m.r += dr[m.dir];
                nc = m.c += dc[m.dir];

                if (nr == 0 || nc == 0 || nr == N-1 || nc == N-1){ // 가장자리
                    if ((m.cnt /= 2) == 0) continue; // 크기 줄인 후 0이면 소멸

                    // 방향 반대로로
                    if(m.dir % 2 == 0)
                        m.dir--;
                    else
                        m.dir++;
                }

                if (map[nr][nc] == null){ // 해당 자리에 처음 이동한 미생물 군집이면 그 자리에 세팅
                    map[nr][nc] = m;
                }else {
                    map[nr][nc].cnt += m.cnt;
                }
            }
            // 한시간 흐름
            remainCnt = reset();
        }
        return remainCnt;
    }

    private static int reset(){ // 매 시간마다 필요한 정리, 초기화 작업업
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != null) {
                    pq.offer(map[i][j]);
                    map[i][j] = null;
                    total += map[i][j].cnt;
                }
            }
        }
        return total;
    }
}
