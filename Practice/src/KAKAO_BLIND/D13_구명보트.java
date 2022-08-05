package KAKAO_BLIND;

import java.util.*;

public class D13_구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70,50,80}, 100));
    }

    private static int solution(int[] people, int limit) {
        int answer = 0;
        // 한 보트에는 두명이 탈 수 있음

        // 50 50 70 80
        Arrays.sort(people);
        int idx = 0;
        int boatCnt = people.length;

        for (int i = people.length - 1; i >= 0; i--) {
            if (idx >= i) break;

            if (people[i] + people[idx] <= limit) {
                idx++;
                boatCnt--;
            }
            if (idx >= i) break;
        }
        return boatCnt;
    }

}
