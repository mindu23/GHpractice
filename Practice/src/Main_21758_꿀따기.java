import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main_21758_꿀따기 {

    static int N;
    static int[] honey;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        List<String> s = Arrays.asList(br.readLine().split(" "));
        int i = 0;
        for (Integer integer : s.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList())) {
            honey[i++] = integer;
        }

        int a = Math.max(getHoney(0,1,N-1), getHoney(N-1, N-2, 0));
        int b = getHoney1();

        System.out.println(Arrays.toString(honey));
    }

    private static int getHoney1() {
        int[] dp = new int[N+1];
        // 맨 왼쪽 > 맨 오른쪽 == 오른쪽이 벌
        //  < == 왼쪽이 벌
        int anotherMax = 0;
        int anotherIdx = 0;
        if (honey[0] > honey[N-1]){
            for (int i = N-2; i >= 0; i--) {
                dp[i] = dp[i+1] + honey[i];

            }
        }else {
            for (int i = 1; i < N; i++) {
                dp[i] = dp[i-1] + honey[i];
            }
        }
        return 0;
    }

    private static int getHoney(int i, int i1, int i2) {
        boolean[] bee = new boolean[N];
        int resI = 0;
        int resI1 = 0;
        if (i < i2){
            for (int j = i+1; j <= i2; j++) {
                if (j == i1) continue;
                resI += honey[j];
            }
        }else {
            for (int j = i2; j > i; j--) {
                if (j == i1) continue;
                resI += honey[j];
            }
        }

        if (i1 < i2){
            for (int j = i1+1; j <= i2; j++) {
                if (j == i) continue;
                resI1 += honey[j];
            }
        }else {
            for (int j = i2; j > i1; j--) {
                if (j == i) continue;
                resI1 += honey[j];
            }
        }

        return resI + resI1;
    }
}
