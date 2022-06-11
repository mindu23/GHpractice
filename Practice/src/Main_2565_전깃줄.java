import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {

    static class Path implements Comparable<Path>{
        int start;
        int end;

        public Path(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Path o) {
            return Integer.compare(this.start, o.start);
        }
    }

    static int N;
    static int res;
    static Path[] paths;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        paths = new Path[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            paths[i] = new Path(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 출발 지점을 기준으로 정렬
        Arrays.sort(paths);

        // 1. 출발 지점이 작은 것부터 포함하거나 말거나
        // 2의 100승인가..?
        dp = new int[N];
        solution();
        System.out.println(N-res);
    }

    static int[] dp;
    private static void solution() {
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            
            // i보다 end가 작으면 ok
            for (int j = 0; j < i; j++) {
                if (paths[i].end > paths[j].end && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }
            }

            res = Math.max(res, dp[i]);
        }
    }
}