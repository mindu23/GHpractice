package TwoPointers;

import java.io.*;
import java.util.StringTokenizer;

/**
    X일 동안 가장 많이 들어온 방문자 수와 기간이 몇 개 있는지 구하기
 */
public class Main_21821_블로그 {

    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, X, arr);
    }

    private static void solution(int n, int x, int[] arr) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 기간
        int k = n - x + 1;
        int[] visit = new int[n];
        visit[0] = arr[0];
        for (int i = 1; i < n; i++) {
            visit[i] = visit[i - 1] + arr[i];
            if (i >= x) {
                visit[i] = visit[i] - arr[i - x];
            }
        }

        int max = 0;
        int max_cnt = 0;
        for (int i = x - 1; i < n; i++) {
            if (max < visit[i]) {
                max = visit[i];
                max_cnt = 1;
            } else if (max == visit[i]) {
                max_cnt++;
            }
        }

        if(max == 0){
            bw.write("SAD");
        }else{
            bw.write(max+"\n"+max_cnt);
        }
        bw.flush();
    }
}
