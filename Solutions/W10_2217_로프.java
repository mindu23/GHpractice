import java.util.Arrays;
import java.util.Scanner;

/**
    N개의 로프를 이용하여 물체를 들어올릴 수 있다.
    각각의 로프는 그 굵기나 길이가 달라 들 수 있는 물체의 중량이 서로 다르다.
    하지만 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
    k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에 고르게 w/k만큼의 중량이 걸린다.
    로프를 사용하여 들어올릴 수 있는 최대 중량을 구해라
 */
public class W10_2217_로프 {

    static int N;
    static int[] rope;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        rope = new int[N+1];
        for (int i = 1; i <= N; i++) {
            rope[i] = sc.nextInt();
        }

        Arrays.sort(rope);
        int max = 0;

        // 하나도 안빼고 ... N-1개 빼고
        for (int i = 0; i < N; i++) {
            int min = rope[i+1];
            int cnt = N-i;
            max = Math.max(max, min*cnt);
        }

        System.out.println(max);
    }
}
