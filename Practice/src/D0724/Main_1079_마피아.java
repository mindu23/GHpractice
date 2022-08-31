package D0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1079_마피아 {

    static int[][] R;
    static int N, M, ans;
    static int[] arr;
    static boolean[] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        R = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 유죄 지수
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken()); // R[i][j]는 i가 죽으면 j의 유죄지수가 R[i][j]만큼 증가
            }
        }

        // 그리디 -> 지금 당장 내가 제일 적은 숫자가 되도록
        M = Integer.parseInt(br.readLine()); // 마지막 남은 마피아의 번호

        ans = 0;
        int remain = N;
        people = new boolean[N];

        // 랜덤하게 문제를 풀어야함 다시!!
        int res = game(remain, ans);

        System.out.println(res);
    }

    private static int game(int remain, int day) {

        if (remain % 2 == 0) {
            // 밤: 마피아가 한명 죽이기
            // 내 유죄 지수가 가장 작을 경우를 구해야 한다.
            // 유죄 지수 변경
            for (int i = 0; i < N; i++) {
                if (people[i] || i == M) continue;
                for (int j = 0; j < N; j++) {
                    arr[i] += R[i][j];
                }
                people[i] = true;
                game(remain - 1, day++);

                for (int j = 0; j < N; j++) {
                    arr[i] -= R[i][j];
                }
                people[i] = false;
            }
        } else {
            // 낮: 유죄지수가 높은 한명 죽이기
            // 유죄 지수 미변경
            int k = 0;
            int maxK = 0;
            for (int i = 0; i < N; i++) {
                if (people[i]) continue;
                if (maxK < arr[i]) {
                    maxK = arr[i];
                    k = i;
                }
            }
            people[k] = true;
            game(remain - 1, day);
        }

        return remain;
    }
}
