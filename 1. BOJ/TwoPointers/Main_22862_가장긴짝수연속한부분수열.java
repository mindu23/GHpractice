package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    수열 S에서 최대 K번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 구해보자
 */
public class Main_22862_가장긴짝수연속한부분수열 {

    static int N, K;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 홀수를 지우자.

        // 1. 홀수의 개수가 K개 까지 p1 늘린다.
        // 2. 해당 길이 구하기
        // 3. p2 늘리면서 홀수의 개수가 K개 이하로 줄면 p1 증가 반복
        solution(N, K, S);

    }

    private static void solution(int n, int k, int[] s) {
        int p1 = 0;
        int p2 = 0;
        int oddCnt = 0;
        int maxLen = 0;
        while (p1 < n){
            if (oddCnt <= k){
                if (s[p1]%2 != 0) oddCnt++;
                p1++;
            }else {
                if (s[p2]%2 != 0) oddCnt--;
                p2++;
            }
            maxLen = Math.max(maxLen, p1-p2-oddCnt);
        }
        System.out.println(maxLen);
    }
}
