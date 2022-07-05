import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

    /**
     * 최대 회의의 개수
     */

    static class Plan{
        int start;
        int end;

        public Plan(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Plan[] plan = new Plan[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            plan[i] = new Plan(s, e);
        }

        Arrays.sort(plan, new Comparator<Plan>() {
            @Override
            public int compare(Plan o1, Plan o2) {
                if (o1.end == o2.end)
                    return Integer.compare(o1.start, o2.start);
                return Integer.compare(o1.end, o2.end);
            }
        });

        int beforeE = 0;
        int ans = 0;
        for (Plan p : plan) {
            // 바로 시작할 수 있으니 = 필수!
            if (beforeE <= p.start){
                ans++;
                beforeE = p.end;
            }
        }

        System.out.println(ans);
    }
}
