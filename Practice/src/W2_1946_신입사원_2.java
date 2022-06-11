import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class W2_1946_신입사원_2 {

    static class Score implements Comparable<Score>{
        int a;
        int b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Score o) {
            return this.a - o.a;
        }
    }

    static Score[] scores;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int N = Integer.parseInt(br.readLine());
            scores = new Score[N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                scores[i] = new Score(a, b);
            }

            Arrays.sort(scores);

            solution(scores, N);
            System.out.println(ans);
        }
    }

    private static void solution(Score[] scores, int N){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(scores[0].b);

        for (int i = 1; i < N; i++) {
            if(pq.peek() > scores[i].b){
                pq.offer(scores[i].b);
            }
        }

        ans = pq.size();
    }
}
