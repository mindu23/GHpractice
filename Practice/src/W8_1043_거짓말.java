import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class W8_1043_거짓말 {

    // make find union
    static int[] parents;
    private static boolean union;
    private static int[] i;
    private static int[] i1;

    private static void make(){
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }


    private static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    private static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    /** 같은 부모를 가졌는가 **/
    private static boolean same_parent(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return true;
        return false;
    }

    static int N, M;
    static int[] knowTruth;
    static LinkedList<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueK =  Integer.parseInt(st.nextToken());
        knowTruth = new int[trueK];
        for (int i = 0; i < trueK; i++) {
            int k = Integer.parseInt(st.nextToken());
            // 진실을 아는 사람들
            knowTruth[i] = k;
        }

        make();
        // 파티에 참여하는 사람들 넣기
        party = new LinkedList[M];
        for (int j = 0; j < M; j++) {
            party[j] = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int partyK = Integer.parseInt(st.nextToken());
            for (int k = 0; k < partyK; k++) {
                int p = Integer.parseInt(st.nextToken());
                party[j].add(p);
            }
            // 같은 파티에 참여한 사람은 모두 같은 parent 값을 같는다.
            for (int k = 1; k < party[j].size(); k++) {
                union(party[j].get(k-1), party[j].get(k));
            }
        }

        int ans = 0;
        // 파티에 참여한 사람의 parent 값과 진실을 아는 사람의 parent 값을 비교 한다.
        for (int j = 0; j < M; j++) {
            boolean isAns = true;
            for (int l = 0; l < party[j].size(); l++) {
                for (int k = 0; k < knowTruth.length; k++) {
                    // 같으면 그 파티는 비밀을 아는 사람이다. -> 진실을 말해야하는 곳
                    if (same_parent(party[j].get(l), knowTruth[k])) isAns = false;
                }
            }
            if (isAns) ans++;
        }

        System.out.println(ans);

    }
}
