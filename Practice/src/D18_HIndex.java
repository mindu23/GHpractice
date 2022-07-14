import java.util.Arrays;

/**
 * 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
 * 나머지 논문이 h번 이상 인용되었다면 h의 최댓값이 이 과학자의 H-Index
 */
public class D18_HIndex {

    public static void main(String[] args) {
        int solution = solution(new int[]{3, 0, 6, 1, 5});
        System.out.println(solution);
    }

    /**
     * @param citations 인용 횟수를 담은 배열
     * @return H-Index
     */
    private static int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);
        int answer = 0;
//        int n = citations.length;
//        for (int i = n-1; i >= 0; i--) {
//            if (n - i >= citations[i] && i <= citations[i]) {
//                answer = citations[i];
//                break;
//            }
//        }
        // 많이 인용된 순으로 정렬 후, 인용수가 논문수와 같아지거나 작아지기 시작한 숫자 h
        for (int i = 0; i < citations.length; i++) {
            // 작아지는 논문 수. 가장 큰 h를 구해야 하므로
            int h = citations.length - i;
            // h회 이상 인용된 논문이 h편 이상
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
