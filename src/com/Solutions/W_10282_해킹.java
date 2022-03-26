import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W_10282_해킹 {

    static class Hack implements Comparable<Hack>{
        int a;
        int b;
        int s;

        public Hack(int a, int b, int s) {
            this.a = a;
            this.b = b;
            this.s = s;
        }

        @Override
        public int compareTo(Hack o) {
            return this.s - o.s;
        }
    }

    static Hack[] hacks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            hacks = new Hack[d];
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                hacks[i] = new Hack(a, b, s);
            }

            ArrayList<Integer> ans = solution(n, c);
            for (Integer an : ans) {
                System.out.print(ans+" ");
            }
        }
    }

    private static ArrayList<Integer> solution(int n, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[c] = 0;
        PriorityQueue<Hack> pq = new PriorityQueue<>();
        int cnt = 0;
//        for (Hack hack : hacks) {
//            if(hack.b == c)
//                pq.offer(new Hack());
//        }



        return list;
    }
}
