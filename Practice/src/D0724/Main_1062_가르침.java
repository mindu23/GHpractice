package D0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침 {

    static int N, K;
    static boolean[] chars;
    static String[] words;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chars = new boolean[26];
        words = new String[N];
        // 무조건 배워야하는 a, n, t, i, c = 5
        char[] cs = new char[] {'a', 'n', 't', 'i', 'c'};
        int k = 0;
        for (char c : cs) {
            int n = c-'a';
            chars[n] = true;
        }

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5){
            System.out.println(0);
            return ;
        }else if (k == 26){
            System.out.println(N);
            return ;
        }

        // knowCnt 중에서 K-5개 뽑기
        comb(0,0);

        System.out.println(ans);
    }

    private static void comb(int cnt, int start) {
        if (cnt == K-5){
            check();
            return ;
        }

        for (int i = start; i < 26; i++) {
            if (chars[i]) continue;
            chars[i] = true;
            comb(cnt + 1, i);
            chars[i] = false;
        }
    }

    private static void check() {
        int cnt = 0;
        for (String word : words) {
            boolean ch = true;
            for (char c : word.toCharArray()) {
                if (chars[c - 'a']) continue;
                else {
                    ch = false;
                    break;
                }
            }
            if (ch) cnt++;
        }
        ans = Math.max(ans, cnt);
    }


}
