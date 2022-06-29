import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main_1923_소수구하기 {

    /**
     * 소수를 찾는 문제 == 에라토스테네스의 체
     * 전부 확인하는 것이 아니라 루트까지만 확인하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);

        boolean[] ck = new boolean[e+1];
        ck[0] = true;
        ck[1] = true;

        // 루트까지만 확인하기
        for (int i = 2; i <= Math.sqrt(e); i++) {
            // 이미 소수가 아닌 경우
            if (ck[i]) continue;
            // i*j가 e보다 작거나 같기 위해서 j <= e/i
            for (int j = 2; j <= e / i; j++) {
                // 배수가 되는 경우, 소수가 아니라고 체크
                if (ck[i * j]) continue;
                ck[i * j] = true;
            }
        }

        for (int i = s; i <= e; i++) {
            if (!ck[i]) bw.write(i+"\n");
        }

        bw.flush();
    }
}
