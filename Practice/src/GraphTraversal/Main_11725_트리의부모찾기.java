package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 루트 없는 트리에서 루트를 1이라고 정했을 때, 각 노드의 부모 구하기
 */
public class Main_11725_트리의부모찾기 {

    static int N;
    static int[] parents;
    static LinkedList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        parents[1] = 1;

        tree = new LinkedList[N+1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            tree[k1].add(k2);
            tree[k2].add(k1);
        }

        // 루트는 1
        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void DFS(int cur){
        // cur은 parent가 없는 아이들에게는 부모
        // cur과 연결된 아이들은 다 cur의 자식
        for (int i = 0; i < tree[cur].size(); i++) {
            int k = tree[cur].get(i);
            // 아직 부모가 없다면
            if (parents[k] == 0) {
                // cur이 부모
                parents[k] = cur;
                // k의 자녀를 찾으러 간다.
                DFS(k);
            }
        }
    }
}
