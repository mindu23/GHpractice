package KAKAO_BLIND;

import java.util.Arrays;
import java.util.Comparator;

public class D14_HIndex {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

    private static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        // h번 이상 인용된 논문이 h편 이상이고 나머지가 h번 이하 인용되었을 때 h의 최댓값
        // 0 1 3 5 6


        for (int i = 0; i < citations.length; i++) {
            // 맨 뒤에서부터 확인하기
            int h = citations.length - i;

            // 오름차 순으로 나열한 것들 중에 해당 것 보다 h가 크거나 같으면 나열한 애들 중 h편 이상
            if (citations[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
