package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 롤케이크자르기_132265 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(new int[]{1,2,1,3,1,4,1,2}));
        // 1,2,2,3,3,4,4,4
        // 4,4,4,4,3,3,2,1
        Assertions.assertEquals(0, solution(new int[]{1,2,3,1,4}));

    }

    /**
     * 롤케이크를 두 조각으로 잘라서 동생과 나눠먹음
     * 토핑이 일렬로 올리짐
     * 각 조각에 동일한 가짓수의 토핑이 올라가도록
     * @param topping
     * @return 공평하게 나누는 방법 가짓수
     */
    private static int solution(int[] topping) {
        int answer = 0;

        // set사용해 해당 idx까지 몇가지 있는지 정하기
        Set<Integer> set1 = new HashSet<>();
        int[] arr1 = new int[topping.length];
        for (int i = 0; i < arr1.length; i++) {
            if (!set1.contains(topping[i])) set1.add(topping[i]);
            arr1[i] = set1.size();
        }

        Set<Integer> set2 = new HashSet<>();
        int[] arr2 = new int[topping.length];
        for (int i = arr2.length-1; i >= 0; i--) {
            if (!set2.contains(topping[i])) set2.add(topping[i]);
            arr2[i] = set2.size();
        }

        for (int i = 0; i < arr1.length-1; i++) {
            if (arr1[i] == arr2[i + 1]) answer++;
        }

        return answer;
    }
}
