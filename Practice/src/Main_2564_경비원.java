import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_2564_경비원 {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int C = Integer.parseInt(br.readLine());
        int[][] p = new int[C+1][2];
        for (int i = 0; i <= C; i++) {
            String[] s1 = br.readLine().split(" ");
            if (Integer.parseInt(s1[0]) >= 3){
                p[i][0] = Integer.parseInt(s1[0])+1;
            }else{
                p[i][0] = Integer.parseInt(s1[0]);
            }
            p[i][1] = Integer.parseInt(s1[1]);
        }

        int ans = 0;
        int[] root = change(p[C]);
        for (int i = 0; i < C; i++) {
            if (Math.abs(p[i][0] - p[C][0]) == 1){
                // 맞은 편
                if (p[i][0] == 1 || p[C][0] == 1){
                    ans += Math.min(M+p[i][1]+p[C][1], M+(N-p[i][1])+(N-p[C][1]));
                }else {
                    ans += Math.min(N+p[i][1]+p[C][1], N+(M-p[i][1])+(M-p[C][1]));
                }
            }else{
                int[] k = change(p[i]);
                // 옆으로 갈 수 있음
                ans += Math.abs(k[0]-root[0])+Math.abs(k[1]-root[1]);
            }
        }

        System.out.println(ans);
    }

    private static int[] change(int[] i) {
        int[] newP = new int[2];

        switch (i[0]){
            case 1:
                newP[0] = M;
                newP[1] = i[1];
                break;
            case 2:
                newP[0] = 0;
                newP[1] = i[1];
                break;
            case 4:
                newP[0] = M-i[1];
                newP[1] = 0;
                break;
            case 5:
                newP[0] = M-i[1];
                newP[1] = N;
                break;
        }

        return newP;
    }
}