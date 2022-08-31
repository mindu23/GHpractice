//package ShortestPath;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_1753_최단경로 {
//
//    static class Edge implements Comparable<Edge> {
//        int u;
//        int v;
//        int w;
//
//        public Edge(int u, int v, int w) {
//            this.u = u;
//            this.v = v;
//            this.w = w;
//        }
//
//        @Override
//        public int compareTo(Edge o) {
//            return Integer.compare(this.w, o.w);
//        }
//    }
//
//    static int V, E, K;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(br.readLine());
//
//        int[] shortestPath = new int[V+1];
//        for (int i = 0; i < shortestPath.length; i++) {
//            shortestPath[i] = Integer.MAX_VALUE;
//        }
//
//        shortestPath[K] = 0;
//
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//            q.offer(new Edge(u, v, w));
//        }
//
//        while (!q.isEmpty()){
//            Edge cur = q.poll();
//
//        }
//
//
//    }
//}
