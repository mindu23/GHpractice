import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1719_택배 {

    static class Path implements Comparable<Path>{
        int from;
        int to;
        int cost;

        public Path(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Path o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m;
    static int[][] map;
    static ArrayList<ArrayList<Path>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new Path(from, to, cost));
            list.get(to).add(new Path(to, from, cost));
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }


    }

    private static void dijkstra(int i) {
        int[] tmp = new int[n+1];
        for (int j = 1; j <= n; j++) {

        }

    }
}
