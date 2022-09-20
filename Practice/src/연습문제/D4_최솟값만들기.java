package 연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class D4_최솟값만들기 {

    public static void main(String[] args) {
        Assertions.assertEquals(29, solution(new int[]{1,4,2}, new int[]{5,4,4}));
    }

    /**
     * 길이가 같은 배열 A, B
     * 각각 한개를 뽑아 두 수를 곱한다. <- 배열의 길이만큼 반복
     * 두 수를 곱한 값을 누적해 더한다.
     * 최종적으로 누적된 값이 최소가 되도록 하자.
     * @param A
     * @param B
     * @return
     */
    private static int solution(int []A, int []B)
    {
        // 제일 작은 값 x 제일 큰값
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        int size = A.length -1;

        for (int i = 0; i < A.length; i++) {
            answer += A[i]*B[size-i];
        }

        return answer;
    }
}
