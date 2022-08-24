package KAKAO_BLIND;

import java.util.Arrays;

public class D15_카펫 {

    public static void main(String[] args) {
        int[] solution = solution(10, 2);
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 가로, 세로 (가로 >= 세로)
        int k = yellow/1;
        for (int i = 1; i <= k; i++) {
            if (yellow % i != 0) continue;
            int c = yellow/i; // 가로
            int r = i; // 세로

            int b = (c+2)*2 + r*2;
            if (brown == b) {
                answer[0] = c+2;
                answer[1] = r+2;
                break;
            }

            k = yellow/(i+1); // 다음 조건
        }
        return answer;
    }
}
