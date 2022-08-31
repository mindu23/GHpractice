import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 연관 동영상 리스트 만들기
 * N-1개의 동영상 쌍을 골라 두 쌍의 USADO 측정
 * 각 동영상을 정점으로 나타내 연결되어 있는 N-1개의 동영상 쌍으로 나타내기 <- 무조건 경로는 하나 존재한다.
 * 두 쌍의 USADO는 그 경로의 연결들 중 최솟값
 */
public class Main_15591_MooTube {

    static class USADO implements Comparable<USADO>{
        int p;
        int q;
        int r;

        public USADO(int p, int q, int r) {
            this.p = p;
            this.q = q;
            this.r = r;
        }

        @Override
        public int compareTo(USADO o) {
            return this.r - o.r;
        }
    }

    static int[] parents;

    static void make(){
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    static int find(int a){
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean uinon(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static int N, Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<USADO> pq = new PriorityQueue<>();
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        int[][] weights = new int[N+1][N+1];
        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            pq.offer(new USADO(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])));
        }

        make();


        for (int i = 0; i < Q; i++) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]); // USADO가 k 이상인 동영상 추천
            int v = Integer.parseInt(s[1]);

            check(k, v);
        }

    }

    private static void check(int k, int v) {
    }
}
