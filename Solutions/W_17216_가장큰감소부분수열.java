import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W_17216_가장큰감소부분수열 {


    static int[] A;
    static int ans;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len_A = Integer.parseInt(st.nextToken());
        A = new int[len_A];
        dp = new int[len_A];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < len_A; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 원래 값을 넣어준다.
        dp = Arrays.copyOf(A, len_A);

        // i는 마지막이 될 index
        for (int i = 0; i < len_A; i++) {
            for (int j = 0; j < i; j++) {
                if(A[j] > A[i])
//                    하나씩 비교하면서 쌓는다.
                    dp[i] = Math.max(dp[i], dp[j]+A[i]);
            }
        }

        System.out.println(dp[A.length-1]);
    }
}