package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
    산성 용액: 1 <=  <= 1,000,000,000. 양의 정수
    알칼리성 용액: -1,000,000,000 <= <= -1. 음의 정수

    같은 양의 두 용액을 혼합한 용액의 특성값은 두 용액의 특성값의 합.
    특성값이 0에 가장 가까운 용액을 만들려고 한다.
    예외) 둘다 알칼리 또는 산성일 수 있다.

 */
public class Main_2470_두용액 {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, arr);

    }

    private static void solution(int n, int[] arr) {
        int p1 = 0, p2 = n-1;
        int[] result = new int[2];
        int minSum = Integer.MAX_VALUE;

        Arrays.sort(arr);

        while(p1 < p2){
            if (Math.abs(arr[p1]+arr[p2]) < minSum){
                result[0] = arr[p1];
                result[1] = arr[p2];
                minSum = Math.abs(arr[p1]+arr[p2]);
            }

            /**
                풀이 참조한 부분 처음에는 그냥 무조건 p1을 올렸는데
                아래처럼 따로 빼서 확인해야 한다.
             */
            if (arr[p1] + arr[p2] < minSum) p1++;
            else p2--;
        }

        System.out.println(result[0]+" "+result[1]);


    }
}
