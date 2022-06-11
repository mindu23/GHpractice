package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

    static boolean[] virus; // 감염 여부 판벌
    static int compCnt; // 총 컴퓨터 개수
    static int connCnt; // 연결 개수
    static boolean[][] map; // 연결 여부
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        compCnt = Integer.parseInt(br.readLine());
        connCnt = Integer.parseInt(br.readLine());
        virus = new boolean[compCnt+1];
        map = new boolean[compCnt+1][compCnt+1];

        for (int i = 0; i < connCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            map[n][m] = true;
            map[m][n] = true;
        }
        virus[1] = true;
        solution(1);

        System.out.println(cnt);
    }

    static void solution(int cur){

        for (int i = 1; i <= compCnt; i++) {
            if (map[cur][i] == false || virus[i]) continue;
            virus[i] = true;
            solution(i);
            cnt++;
        }
    }
}
