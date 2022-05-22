package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16398 {

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

    private static int[] parents;
    private static void make(){
        parents = new int[N];
        for (int i = 0; i < N; i++) {
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

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Edges> pq = new PriorityQueue<>();

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(i==j) continue;
                if(!visited[i][j]) pq.offer(new Edges(i, j, c));
                visited[i][j] = true;
                visited[j][i] = true;
            }
        }

        make();
        int cnt = 0;
        long ans = 0;
        while (!pq.isEmpty()){
            Edges e = pq.poll();
            if(union(e.a, e.b)){
                cnt++;
                ans += e.c;
            }

            if (cnt == N-1) break;
        }

        System.out.println(ans);
    }
}
