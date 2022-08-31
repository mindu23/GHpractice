import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * K개의 랜선으로 N개의 랜선 만들기
 */
public class Main_1654_랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] line = new int[K];
        long max = 1;

        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            // 제일 긴 값
            max = max<line[i]?line[i]:max;
        }

        Arrays.sort(line);

        /**
         * 이분 탐색
         * 가장 짧은 길이는 1, 가장 긴 길이는 가장 긴 랜선으로 mid 값 구하기
         * 길이로 잘랐을 때 잘라진 랜선의 개수가 N보다 크면 mid 값 이하는 필요 없습
         * 반복
         */
        long u = upperBound(line, max, N);
        System.out.println(u-1);
    }

    private static long upperBound(int[] line, long max, int N) {
        long min = 1;

        while (min < max){
            long mid = (min + max) / 2;
            long cnt = 0;

            for (int l : line) {
                cnt += l/mid;
            }

            if (cnt < N){
                max = mid;
            }else {
                min = mid+1;
            }
        }
        return min;
    }
}
