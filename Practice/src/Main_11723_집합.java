import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_11723_집합 {

    static int[] S = new int[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()){
                x = Integer.parseInt(st.nextToken());
            }
            switch (command){
                case "add":
                    S[x] = 1;
                    break;
                case "remove":
                    S[x] = 0;
                    break;
                case "check":
                    if (S[x] == 1) bw.write(1+"\n");
                    else bw.write(0+"\n");
                    break;
                case "toggle":
                    S[x] = S[x]==1?0:1;
                    break;
                case "all":
                    allIn(1);
                    break;
                case "empty":
                    allIn(0);
                    break;

            }
        }
        bw.flush();
    }

    private static void allIn(int n) {
        for (int i = 0; i < 21; i++) {
            S[i] = n;
        }
    }
}
