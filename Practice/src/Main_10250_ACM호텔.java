import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10250_ACM호텔 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken()); // r
            int W = Integer.parseInt(st.nextToken()); // c
            int N = Integer.parseInt(st.nextToken()); // 10번째 손님이 들어갈 방.

            int ans = 0;
            // 맨 왼쪽부터 시작한다 101부터 .. H01 다음 -> 102 H02 ... -> 1W ..HW
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    N--;
                    if (N == 0){
                        ans += (j+1)*100;
                        ans += i+1;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
