import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class W_16202_MST게임 {

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    // make find union
    static int[] parent;
    private static void make(){
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }

    static int N, M, K;
    static int[] scores;
    public static void main(String[] args) throws IOException {

        List<Edge> edgeList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[K];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(s,e,i));
        }

        Collections.sort(edgeList);

        for (int i = 0; i < K; i++) {
            make();
            int cnt = 0;
            int score = 0;
            for (Edge edge : edgeList) {
                int s = edge.s;
                int e = edge.e;
                if(union(s,e)) {
                    score += edge.w;
                    cnt++;
                    if (cnt == N-1){
                        scores[i] = score;
                        break;
                    }
                }
            }
            edgeList.remove(0);
            if (scores[i] == 0) break;
        }

        for (int score : scores) {
            System.out.print(score+" ");
        }

    }
}
