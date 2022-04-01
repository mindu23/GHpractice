package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197 {

    static class Edges implements Comparable<Edges>{
        private int s;
        private int e;
        private int w;

        public Edges(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edges o) {
            return this.w - o.w;
        }
    }

    static int[] parents;
    static int V, E;
    private static void make(){
        parents = new int[V+1];
        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(parents[a] == a) return a;
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
        PriorityQueue<Edges> pq = new PriorityQueue<>();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edges(s, e, w));
        }

        make();
        int ans = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Edges edges = pq.poll();
            if(union(edges.s, edges.e)){
                cnt++;
                ans += edges.w;
            }
            if(cnt == E-1) break;
        }

        System.out.println(ans);

    }
}
