package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 M*N의 보드에서 8*8 체스판을 만들어야 한다
 다시 칠해야 하는 정사각형 개수의 최솟값 구하기

 일단 자르고 색칠
 자를 때 어떻게 잘라야 하나
 자르고 확인을 반복
 최대 50*50 -> 42*42 = 가능
 */

public class Main_1018_체스판다시칠하기 {

    static int N, M, minCnt = Integer.MAX_VALUE, k = 8;
    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chess = new char[N][M];

        for (int i = 0; i < N; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= N - k; i++) {
            for (int j = 0; j <= M - k; j++) {
                isChess(i,j);
            }
        }

        System.out.println(minCnt);
    }

    // 8*8 보드가 색이 잘 칠해져 있는지 확인하기
    private static void isChess(int r, int c) {
        int cntW = 0; // W으로 시작한 경우 칠해야 하는 색
        int cntB = 0; // B로 시작한 경우 칠해야 하는 색
        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                if((i+j)%2==0){
                    if (chess[i][j] != 'B') cntW++;
                    if (chess[i][j] != 'W') cntB++;
                }else {
                    if (chess[i][j] != 'W') cntW++;
                    if (chess[i][j] != 'B') cntB++;
                }
            }
        }
        int min = Math.min(cntW, cntB);
        minCnt = Math.min(min, minCnt);
    }
}
