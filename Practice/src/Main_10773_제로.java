import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10773_제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int res = 0;
        int[] nums = new int[K];
        int beforeIdx = 0;

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0){
                nums[beforeIdx++] = n;
                res += n;
            }else {
                res -= nums[--beforeIdx];
            }
        }

        System.out.println(res);
    }
}
