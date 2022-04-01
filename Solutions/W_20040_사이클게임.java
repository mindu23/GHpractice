import java.io.*;
import java.util.StringTokenizer;

public class W_20040_사이클게임 {

    static int[] parents;
    private static void make(){
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    private static int find(int a){
        if(parents[a] == a) return parents[a];
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static int N, M;
    public static void main(String[] args) throws IOException {
        // make, find, union
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = 0;
        make();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(!union(s,e)){
                ans = i;
                break;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
