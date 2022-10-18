package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class D5_숫자의표현 {

    public static void main(String[] args) {
        Assertions.assertEquals(4, solution(15));
    }

    /**
     * 연속한 자연수로 n을 만들 수 있는 개수
     * @param n
     * @return
     */
    private static int solution(int n) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n){
                    answer++;
                    break;
                }else if (sum > n) break;
            }
        }

        return answer;
    }
}
