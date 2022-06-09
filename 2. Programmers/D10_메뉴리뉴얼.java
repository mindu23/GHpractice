import java.util.Arrays;

/**
    새로운 메뉴 구상 -> 메뉴 조합
    각 손님들이 주문할 때 가장 많이 함께 주문한 단품 메뉴들을 코스요리 메뉴로 구성
    - 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성
    - 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에서만 코스요리 메뉴 후보 포함 <- 한명만 주문한건 포함 안됨

    - 각 손님은 단품메뉴를 2개 이상 주문해야함.
 */
public class D10_메뉴리뉴얼 {

    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] solution = solution(orders, course);
        System.out.println(Arrays.toString(solution));
    }

    /**
     *
     * @param orders 손님이 주문한 단품 메뉴들
     * @param course 코스요리를 구성하는 단품 메뉴들의 갯수
     * @return 추가하게 될 코스요리의 메뉴 구성성     */
    private static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        return answer;
    }
}
