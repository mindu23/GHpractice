import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_25345_루나의게임세팅 {

    static int K, N;
    static long ans;
    static int[] A;
    static boolean[] v;
    static int[] game;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        v = new boolean[N];
        game = new int[K];
        ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        sol(0);

        System.out.println(ans % (1000000007));

    }

    private static void sol(int cnt) {
        if (cnt == K){
            if (check()) ans++;
            return ;
        }

        for (int i = 0; i < N; i++) {
            if (v[i]) continue;
            v[i] = true;
            game[cnt] = A[i];
            sol(cnt + 1);
            v[i] = false;
        }
    }

    private static boolean check() {
        // 큰거 사이에 하나가 껴있으면 안된다.
        // 1.증가 -> 감소 2. 증가 3. 감소
        boolean change = false;
        if (K != 1){
            change = game[0] - game[1] < 0 ? false : true; //false는 증가 true는 감소
            if (change){ // 감소면 계속 감소해야한다.
                for (int i = 1; i < K; i++) {
                    if (game[i - 1] - game[i] < 0 ? true : false) {
                        return false;
                    }
                }
                return true;
            }else{ // 증가면 계속 증가 혹은 증가하다 감수
                int changeCnt = 0; // 1번 변해야 함
                for (int i = 1; i < K; i++) {
                    if (changeCnt == 0 && game[i - 1] - game[i] < 0 ? false : true) {
                        // 감소함
                        changeCnt++;
                    }
                    // 변했을 경우 증가하면
                    else if (changeCnt == 1 && game[i - 1] - game[i] < 0 ? true: false){
                        return false;
                    }
                }
                return true;
            }
        }else{
            return true;
        }
    }
}
