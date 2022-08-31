package DivideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17829_222풀링 {

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int sol = solution(N);
        System.out.println(sol);
    }

    private static int solution(int n) {
        int[] k = new int[n/2];
        for (int i = 0; i < k.length; i++) {
            k[i] = i;
        }

        int[][] mmap = new int[n/2][n/2];
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k.length; j++) {

            }
        }

        if (k.length == 1) return k[0];
        return 0;
    }
}
