package KAKAO_BLIND;

import java.util.Arrays;

public class D11_큰수만들기 {

    public static void main(String[] args) {
        String solution = solution2("4177252841", 4);
        System.out.println(solution);
    }

    private static String solution(String number, int k) {
        String answer = "";
        char[] numbers = number.toCharArray();
        // 필요한 글자수만큼 반복하기
        int idx = -1;
        for (int i = 0; i < numbers.length-k; i++) {

            char max = 0; // i가 시작할 수 있는 최소값
            // 앞에서 남겨야하는 수 중 가장 큰 수
            for (int j = idx+1; j <= k+i; j++) {
                if (max < numbers[j]){
                    idx = j;
                    max = numbers[j];
                }
            }
            // 범위 중 가장 큰 수가 나옴
            answer += max;
        }
        return answer;
    }

    private static String solution2(String number, int k) {
        String answer = "";
        // 가장 큰 값의 인덱스 정보.
        int idx = 0;
        // 만들어야 하는 자리 수, 고정 값.
        int scope = number.length()-k;

        for (int i = 1; i <= scope; i++) {
            // 최댓값
            char max = '0';
            // 각 자리 수를 정하기 위해 탐색
            for (int j = 0; j < number.length()-(scope-i); j++) {
                if (number.charAt(j) == '9'){
                    max = '9';
                    idx = j;
                    break;
                }

                if (number.charAt(j) > max){
                    max = number.charAt(j);
                    idx = j;
                }

            }
            answer += max;
            number = number.substring(idx+1, number.length());
        }
        return answer;
    }
}
