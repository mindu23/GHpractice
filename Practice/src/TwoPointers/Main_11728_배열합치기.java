package TwoPointers;

import java.io.*;
import java.util.StringTokenizer;

/**
    정렬된 두 배열을 합쳐서 정렬해라
 */
public class Main_11728_배열합치기 {

    static int N, M;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        solution(A, B, N, M);
    }

    private static void solution(int[] a, int[] b, int n, int m) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n1 = 0;
        int m1 = 0;
        for (int i = 0; i < n+m; i++) {
            if (n1 >= n){
                bw.write(b[m1++]+" ");
                continue;
            }else if(m1 >= m){
                bw.write(a[n1++]+" ");
                continue;
            }
            if (a[n1] < b[m1]){
                bw.write(a[n1++]+" ");
            }else{
                bw.write(b[m1++]+" ");
            }
        }
        bw.flush();
    }
}
