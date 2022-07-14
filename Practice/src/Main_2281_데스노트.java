import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 이미 정해진 순서대로 n명의 이름을 적는다.
 * 2. 노트 위에서 아래로, 같은 줄에서는 왼쪽 맨 끝부터 오른쪽으로 차례로 적는다.
 * 3. 이름 사이에 빈 칸을 둔다.
 * 4. 적다가 한 줄에 이름이 다 들어가지 않으면 새로운 줄로 넘어가서 써야 한다.
 * => 각 줄의 끝에 사용하지 않고 남게 되는 칸의 수의 제곱의 합이 >>최소<<가 되도록 하자.
 *      마지막 줄은 계산하지 않는다.
 */
public class Main_2281_데스노트 {

    static int n, m;
    static int[] name;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 이름의 개수
        m = Integer.parseInt(st.nextToken()); // 노트의 가로 칸 개수
        name = new int[n];
        for (int i = 0; i < n; i++) {
            name[i] = Integer.parseInt(br.readLine());
        }

        // failed : 뒤부터 시작하자
        // dp[i]:  i번째 이름을 새 줄에서 시작했을 때, 그 뒤 이름들로 채워서 얻을 수 있는 빈칸 제곱 합의 최소
        // 1. 이어서 쓸건지 2. 새 줄에 쓸건지
        dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0; // 마지막 줄은 검사하지 않는다.
        // 하나씩 내려가면서 확인한다.
        System.out.println(solution(0));
    }

    private static int solution(int idx) {
        // 계산한 적 있으면 리턴
        if (dp[idx] < Integer.MAX_VALUE)
            return dp[idx];

        int r = m - name[idx]; // r은 뒤에 남은 칸 수

        // 해당 줄에 i번째 이름을 이어 붙인다. 근데 남은 칸 수가 0보다 클 경우까지
        for (int i = idx+1; i <= n && r >= 0; i++) {
            if (i == n){
                // 맨 마지막 줄은 계산하지 않는다.
                dp[idx] = 0;
                break;
            }

            // r * r + i번째 연결하기
            // dp는 계속 업데이트 된다.
            dp[idx] = Math.min(dp[idx], r * r + solution(i));
            r -= name[i]+1;
        }
        return dp[idx];
    }
}
