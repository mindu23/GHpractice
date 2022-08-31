import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25332_수들의합8 {

    static int N;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        for (int i = 0; i < N; i++) {
            long dp[][] = new long[2][N];
            // i부터
            for (int j = i+1; j < N; j++) {
                dp[0][j] = dp[0][j-1] + A[j];
                dp[1][j] = dp[1][j-1] + B[j];
                if (dp[0][j] == dp[1][j]) ans++;
            }
        }
        System.out.println(ans);
    }
}
