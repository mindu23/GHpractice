import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {

    static int B = 0, W = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int blue = 0;
        int white = 0;
        // 전체가 0이거나 1로 하나의 색종이일 경우 체크
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) blue++;
                if (arr[i][j] == 0) white++;
            }
        }
        if (blue == N*N) B++;
        else if(white == N*N) W++;
        else solution(0, 0, N, arr);
        System.out.println(W);
        System.out.println(B);
    }

    private static void solution(int r, int c, int n, int[][] arr) {
        if (n < 0) return;

        int w = n/2;
        int blue = 0;
        int white = 0;
        for (int i = r; i < r + w; i++) {
            for (int j = c; j < c + w; j++) {
                if (arr[i][j] == 1) blue++;
                if (arr[i][j] == 0) white++;
            }
        }
        if (blue == w*w) B++;
        else if(white == w*w) W++;
        else solution(r, c, w, arr);

        blue = 0;
        white = 0;
        for (int i = r; i < r + w; i++) {
            for (int j = c + w; j < c + n; j++) {
                if (arr[i][j] == 1) blue++;
                if (arr[i][j] == 0) white++;
            }
        }
        if (blue == w*w) B++;
        else if(white == w*w) W++;
        else solution(r, c+w, w, arr);

        blue = 0;
        white = 0;
        for (int i = r + w; i < r + n; i++) {
            for (int j = c; j < c + w; j++) {
                if (arr[i][j] == 1) blue++;
                if (arr[i][j] == 0) white++;
            }
        }
        if (blue == w*w) B++;
        else if(white == w*w) W++;
        else solution(r+w, c, w, arr);

        blue = 0;
        white = 0;
        for (int i = r + w; i < r + n; i++) {
            for (int j = c + w; j < c + n; j++) {
                if (arr[i][j] == 1) blue++;
                if (arr[i][j] == 0) white++;
            }
        }
        if (blue == w*w) B++;
        else if(white == w*w) W++;
        else solution(r+w, c+w, w, arr);
    }
}
