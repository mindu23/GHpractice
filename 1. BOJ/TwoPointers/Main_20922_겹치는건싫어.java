package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
    홍대병 걸린 도현이 같은 원소가 K개 이하로 들어가 있는 최장 연속 부분 수열의 길이를 구한다.
    start와 end로 구하기
 */
public class Main_20922_겹치는건싫어 {

    static int N, K;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, K, a);
    }

    private static void solution(int n, int k, int[] a) {
        int[] numCnt = new int[100001];
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while (start < n){
            if (numCnt[a[start]] < k){
                numCnt[a[start]]++;
                start++;
            }else {
                numCnt[a[end]]--;
                end++;
            }
            maxLen = Math.max(maxLen, start-end);
        }

        System.out.println(maxLen);
    }
}
