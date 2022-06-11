import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException {
        // -를 기준으로 나누고 다 더한 후 -를 실행한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int cnt = st.countTokens();
        int[] nums = new int[cnt];
        int res = 0;

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            int k = 0;
            while (st2.hasMoreTokens()){
                k += Integer.parseInt(st2.nextToken());
            }
            nums[i] = k;
        }

        res += nums[0];
        for (int i = 1; i < cnt; i++) {
            res -= nums[i];
        }

        System.out.println(res);
    }
}
