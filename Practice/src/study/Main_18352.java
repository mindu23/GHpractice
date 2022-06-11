package study;

import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int n;
    int d;

    public Pair(int n, int d) {
        this.n = n;
        this.d = d;
    }

    @Override
    public int compareTo(Pair o) {
        return this.d - o.d;
    }
}

public class Main_18352 {

    static final int INFINITY = Integer.MAX_VALUE;
    static int N, M, K, X;
    static ArrayList<Integer>[] S;
    static int[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        S = new ArrayList[N+1];
        D = new int[N+1];

        for(int i = 1; i <= N; i++){
            S[i] = new ArrayList<>();
        }

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            S[start].add(end);
        }

        dijkstra();

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(D[i] == K){
                list.add(i);
            }
        }

        if(list.size() == 0){
            bw.write(-1+"\n");
        }else{
            for(int n: list){
                bw.write(n+"\n");
            }
        }
        bw.flush();
    }

    private static void dijkstra() {
        // 다음으로 방문할 경유지 선택
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // distance 초기화
        Arrays.fill(D, INFINITY);
        D[X] = 0;

        pq.comparator();
        pq.offer(new Pair(X, D[X]));

        while(!pq.isEmpty()){

            Pair cur = pq.poll();
            // 현재 정점을 경유지로 갈 수 있는 정점 처리
            for (int j : S[cur.n]) {
                if (D[j] > cur.d + 1) {
                    D[j] = cur.d + 1;
                    pq.offer(new Pair(j, D[j]));
                }
            }
        }
    }
}
