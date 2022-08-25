package KAKAO_BLIND;

import java.util.PriorityQueue;

public class D16_섬연결하기 {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
    }

    private static int solution(int n, int[][] costs) {
        // 최소 비용으로 모든 섬 통행 MST
        PriorityQueue<Island> q = new PriorityQueue<>();
        int answer = 0;
        make(n);

        for (int i = 0; i < costs.length; i++) {
            int[] cur = costs[i];
            q.offer(new Island(cur[0], cur[1], cur[2]));
        }

        while (!q.isEmpty()){
            Island cur = q.poll();
            if (union(cur.a, cur.b)){
                answer += cur.cost;
            }
        }

        return answer;
    }

    static class Island implements Comparable<Island> {
        int a;
        int b;
        int cost;

        public Island(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Island o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[] parents;

    static void make(int n){
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    static int find(int a){
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
