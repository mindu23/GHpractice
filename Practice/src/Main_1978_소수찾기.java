import java.io.*;
import java.util.StringTokenizer;

public class Main_1978_소수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(st.nextToken());
            if(prime(K)) ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean prime(int k) {
        if (k == 1) return false;
        // 수가 적어서 간단하게 다 돌려도 될 듯
        for (int i = 2; i < k; i++) {
            if (k%i==0) return false;
        }
        return true;
    }
}
