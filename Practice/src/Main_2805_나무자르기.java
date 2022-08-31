import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int ans = 0;

        int min = 0;
        int mid;
        while (min < max){
            mid = (max + min) / 2;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (trees[i] - mid > 0) sum += trees[i] - mid;
            }
            if (sum == M) {
                System.out.println(mid);
                break;
            }
            if (sum < M){


            }
        }

        System.out.println(ans);

    }
}
