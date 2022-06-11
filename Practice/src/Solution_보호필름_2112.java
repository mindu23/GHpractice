import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_보호필름_2112 {

    static int D, W, K, min;
    static int[][] film;
    static final int A=0, B=1;
    static int[] drugA, drugB; // 막 하나의 약품을 표현하는 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            drugA = new int[W];
            drugB = new int[W];
            min = K;
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.fill(drugA, A);
            Arrays.fill(drugB, B);

            // 부분 집합을 구한다.
            // 부분 집합이 만들어질 때마다 해당 행에 보호 약품 투여
            // 이때 min을 넘어가면 그만두기

            process(0,0);
            System.out.println(min);

        }
    }

    private static boolean check(){ // 보호필름 성능 검사
        // 열을 고정하고 행을 탐색하면서 연속된 셀에 같은 특성이 K개 이상인지 검사
        for (int i = 0; i < W; i++) {
            int count = 1;
            int before = film[0][i];

            for (int j = 1; j < D; j++) {
                if (film[j][i] == before){
                    if (++count == K) break;

                }else{
                    before = film[j][i];
                    count = 1;
                }
            }// 하나의 열을 고정해서 수직검사
            if (count < K) return false;
        }

        return true;
    }

    private static boolean process(int row, int useCnt){ // 각 막에 부분집합으로 약품 비투여, 약품A 투여, 약품B 투여여

        if(row == D){
            if(check()){
                min = Math.min(min, useCnt);
                return min==0; // 약품을 하나도 사용하지 않았으면 true, 사용했으면 false
            }
            return false; // 성분검사 패스 안됨
        }

        // 기존 임시 최적해의 최소 약품 수보다 현재까지 사용한 약품수가 같거나 크면 의미 없으므로 리턴
        if(useCnt >= min) return false;

        int[] backup = film[row];

        // 약품 비투여
        if(process(row+1, useCnt)) return true;

        // 약품A 투여
        film[row] = drugA;
        if(process(row+1, useCnt+1)) return true;

        // 약품B 투여
        film[row] = drugB;
        if(process(row+1, useCnt+1)) return true;

        film[row] = backup;

        return false;
    }
}
