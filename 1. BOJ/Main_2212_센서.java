import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212_센서 {

    static int N, K;
    static int[] sensor, distance;
    public static void main(String[] args) throws IOException {
        // 고속도로 위에 N개의 센서
        // 최대 K개의 집중국
        // 센서가 적어도 하나의 칩중국과는 통신이 가능해야 함.
        // 집중국 유지비 문제로 각 집중국의 수신 가능 영역의 길이의 합 최소화

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensor = new int[N];
        distance = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        // 센서 정렬하기
        Arrays.sort(sensor);

        // 센서 사이의 거리 구하기
        for (int i = 0; i < N-1; i++) {
            distance[i] = sensor[i+1] - sensor[i];
        }

        // 센서들의 모임 K개를 만든다. 멀리 있는 애들 단위로 나누자
        Arrays.sort(distance);

        // K가 2라면 한번 나뉘어야 하므로 +1이 있다.
        int ans = 0;
        for (int i = 0; i < distance.length - K + 1; i++) {
            ans += distance[i];
        }

        //System.out.println(Arrays.toString(distance));
        System.out.println(ans);
    }
}
