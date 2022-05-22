package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21924 {

    static class Edges implements Comparable<Edges>{
        private int a;
        private int b;
        private int c;

        public Edges(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edges o) {
            return this.c - o.c;
        }
    }

    private static int N, M;
    private static int[] parents;
    private static void make(){
        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edges> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long max = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.offer(new Edges(a, b, c));
            max += c;
        }

        make();

        int cnt = 0;
        long ans = 0;
        while (!pq.isEmpty()){
            Edges e = pq.poll();
            if (union(e.a, e.b)){
                cnt++;
                ans += e.c;
            }
            if (cnt == N-1) break;
        }
        ans = max - ans;

        if (cnt != N-1) ans = -1;

        System.out.println(ans);

    }
}
