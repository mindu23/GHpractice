import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

    static class Path implements Comparable<Path>{
        int to;
        int time;

        public Path(int to, int time) {
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Path o) {
            return Integer.compare(this.time, o.time);
        }
    }

    static int N, M, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        // N -> X로
        // X -> N로

        ArrayList<ArrayList<Path>> list = new ArrayList<>();
        ArrayList<ArrayList<Path>> list_r = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            list_r.add(new ArrayList<>());
        }

        // 단방향 간선 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list.get(from).add(new Path(to, time));
            list_r.get(to).add(new Path(from, time));
        }

        // X에서 모든 정점 까지의 거리
        int[] dist1 = dijkstra(list, X);
        // 모든 정점에서 X까지의 거리
        int[] dist2 = dijkstra(list_r, X);

        int ans = 0;
        for (int i = 0; i < dist1.length; i++) {
            ans = Math.max(ans, dist1[i]+dist2[i]);
        }
        System.out.println(ans);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Path>> list, int x) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[x] = 0;
        pq.offer(new Path(x, 0));

        while (!pq.isEmpty()){
            Path temp = pq.poll();
            // 지금 있는 곳
            int cur = temp.to;

            // 연결된 아이들 중 time이 작은 값부터 나오기 때문에, 먼저 나오면 가장 작은 것.
            // 방문하지 않은 곳이라면
            if (!visited[cur]){
                visited[cur] = true;

                // 지금 있는 곳과 연결된 곳 확인
                for (Path path : list.get(cur)) {
                    // 방문하지 않았고 현재까지 온 거리 + 갈수 있는 값 < 갈 수 있는 곳까지의 거리
                    if (!visited[path.to] && distance[cur]+ path.time < distance[path.to]){
                        distance[path.to] = distance[cur] + path.time;
                        pq.offer(new Path(path.to, distance[path.to]));
                    }
                }
            }
        }

        return distance;
    }

}
