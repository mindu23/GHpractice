import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class W6_1446_지름길 {

    static class Pair implements Comparable<Pair>{
        int n;
        int d;

        public Pair(int n, int d){
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.n == o.n)
                return this.d - o.d;
            else
                return this.n - o.n;
        }
    }

    static int N, D, ans;
    static int[] distance;
    static ArrayList<int[]>[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 도착점 인덱스
        D = Integer.parseInt(st.nextToken());
        // 거리
        distance = new int[D+1];
        S = new ArrayList[D+1];

        for(int i = 0; i <= D; i++){
            S[i] = new ArrayList<>();
        }

        // distance 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(e - s < d || s < 0 || e > D) continue;

            S[s].add(new int[]{e, d});
        }

        dijkstra();

        System.out.println(distance[D]);
    }

    private static void dijkstra(){

//        int idx = 0, move = 0;
//        while(move < D){
//            if(idx < )
//        }
    }
}
