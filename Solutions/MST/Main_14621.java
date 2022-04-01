package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_14621 {

    static class Edges implements Comparable<Edges>{
        private int u;
        private int v;
        private int d;

        public Edges(int u, int v, int d) {
            this.u = u;
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Edges o) {
            return this.d - o.d;
        }
    }

    private static int[] parents;
    private static int N, M;
    private static void make(){
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Edges> pq = new PriorityQueue<>();
        String[] gender = new String[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            gender[i] = st.nextToken();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(!gender[u].contains(gender[v])) {
                pq.offer(new Edges(u, v, d));
            }
        }

        make();

        int cnt = 0;
        int ans = 0;
        int size = pq.size();
        while (!pq.isEmpty()) {
            Edges e = pq.poll();
            if(union(e.u, e.v)){
                cnt++;
                ans += e.d;
            }

            if (cnt == N-1) break;
        }

        if (cnt != N-1) ans = -1;

        System.out.println(ans);
    }
}
