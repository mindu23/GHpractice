package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010 {

    static int N, M;
    static long ans;
    static long[][] C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;

            C = new long[N+1][M+1];
            for (int i = 1; i <= M; i++) {
                C[1][i] = i;
            }

            for (int i = 2; i <= N; i++) {
                for (int j = i; j <= M; j++) {
                    C[i][j] = C[i-1][j-1] + C[i][j-1];
                }
            }
            System.out.println(C[N][M]);
        }
    }
}
