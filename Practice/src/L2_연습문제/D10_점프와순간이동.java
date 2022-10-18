package L2_연습문제;

import org.junit.jupiter.api.Assertions;

public class D10_점프와순간이동 {

    public static void main(String[] args) {
        Assertions.assertEquals(2,solution(5));
        Assertions.assertEquals(2,solution(6));
        Assertions.assertEquals(5,solution(5000));
    }

    /**
     * K칸 만큼 점프하면 건전지 사용량-K
     * 현재까지 온 거리 * 2 순간이동하면 사용량 그대로
     * @param n
     * @return
     */
    static int[] dp = new int[1000000001];
    private static int solution(int n) {
        int ans = 0;

        ans = sol(n);

        return ans;
    }

    private static int sol(int n) {
        if (n==0 || n == 1) return n;
        return n%2==0?sol(n/2):sol(n/2)+1;
    }
}
