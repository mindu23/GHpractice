import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {

    static char[] K, S;
    static int[] k, s;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = st.nextToken().toCharArray();
        k = new int[K.length];
        k[0] = K[0] - 'A';
        k[1] = '8' - K[1];
        S = st.nextToken().toCharArray();
        s = new int[S.length];
        s[0] = S[0] - 'A';
        s[1] = '8' - S[1];

        N = Integer.parseInt(st.nextToken());
        String[] command = new String[N];
        for (int i = 0; i < N; i++) {
            command[i] = br.readLine();
        }

        solution(command);
    }

    static int[] dr = {0,0,1,-1}; // 오 왼 하 상 오위 왼위 오아 왼아
    static int[] dc = {1,-1,0,0};
    private static void solution(String[] command) {
        // int[] 열, 행
        for (String str : command) {
            move(str);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        char k0 = (char) (k[0] + 'A');
        char k1 = (char) ('8' - k[1]);
        sb.append(k0);
        sb.append(k1+"\n");
        char s0 = (char) (s[0] + 'A');
        char s1 = (char) ('8' - s[1]);
        sb.append(s0);
        sb.append(s1);
        System.out.println(sb.toString());
    }

    private static void move(String str) {
        int nr = 0;
        int nc = 0;
        int num = 0;
        for (char c : str.toCharArray()) {
            switch (c){
                case 'R':
                    num = 0;
                    break;
                case 'L':
                    num = 1;
                    break;
                case 'B':
                    num = 2;
                    break;
                case 'T':
                    num = 3;
                    break;
            }
            nr += dr[num];
            nc += dc[num];
        }

        if (k[1]+nr < 0 || k[1]+nr >= 8 || k[0]+nc < 0 || k[0]+nc >= 8) return;
        if (s[1] == k[1]+nr && s[0] == k[0]+nc) {
            if (s[1]+nr < 0 || s[1]+nr >= 8 || s[0]+nc < 0 || s[0]+nc >= 8) return;
            s[1] += nr;
            s[0] += nc;
        }
        k[1] += nr;
        k[0] += nc;
    }
}
