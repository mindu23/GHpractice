package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

    static int N, M, V;
    static boolean[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = true;
            map[to][from] = true;
        }
        sb = new StringBuilder();
        DFS(V, new boolean[N+1]);
        System.out.println(sb.toString());
        sb.setLength(0);
        BFS(V, new boolean[N+1]);
        System.out.println(sb.toString());
    }

    static void DFS(int cur, boolean[] visited){
        visited[cur] = true;
        sb.append(cur+" ");
        for (int i = 1; i <= N; i++) {
            if (visited[i] || !map[cur][i]) continue;
            visited[i] = true;
            DFS(i, visited);
        }
    }

    static void BFS(int cur, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(cur);
        visited[cur] = true;

        while(!q.isEmpty()){
            int c = q.poll();
            sb.append(c+" ");
            for (int i = 1; i <= N; i++) {
                if (visited[i] || !map[c][i]) continue;
                visited[i] = true;
                q.offer(i);
            }
        }
    }
}
