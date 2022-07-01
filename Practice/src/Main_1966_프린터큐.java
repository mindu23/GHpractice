import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐 {

    static class Q{
        int num;
        int p;

        public Q(int num, int p) {
            this.num = num;
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Queue<Q> q = new LinkedList<>();
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.offer(new Q(i, p));
                list.add(p);
            }

            Collections.sort(list, (o1, o2) -> -1*Integer.compare(o1, o2));

            int cnt = 0;
            while (!q.isEmpty()){
                Q cur = q.poll();
                if (cur.p != list.get(0)){
                    q.offer(cur);
                }else {
                    list.remove(0);
                    cnt++;
                    if (cur.num == M){
                        bw.write(cnt+"\n");
                        break;
                    }
                }
            }
        }
        bw.flush();
    }
}
