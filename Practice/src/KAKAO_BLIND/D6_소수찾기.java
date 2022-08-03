package KAKAO_BLIND;

import java.util.*;

public class D6_소수찾기 {

    public static void main(String[] args) {
        int solution = solution("17");
        System.out.println(solution);
//        System.out.println('4'-'0');
    }

    static boolean[] ck;
    // hashSet을 사용하는 이유는 객체를 저장해서 중복을 허용하지 않음.
    static HashSet<Integer> numberSet = new HashSet<>();
    private static int solution(String numbers) {

        // 소수
        ck = new boolean[10000000];
        int k = ck.length - 1;
        ck[0] = true;
        ck[1] = true;
        // 루트까지만 탐색하기
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (ck[i]) continue;
            // i*j <= ck.length
            for (int j = 2; j <= k/i ; j++) {
                ck[i*j] = true;
            }
        }

        // 1. 모든 조합의 숫자 만들기
        recursive("", numbers);

        Iterator<Integer> it = numberSet.iterator();
        int answer = 0;
        while (it.hasNext()){
            int i = it.next();
            if (!ck[i]) answer++;
        }
        return answer;
    }

    private static void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals("")) numberSet.add(Integer.parseInt(comb));

        // 2. 남은 숫자 중 한개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb+others.charAt(i), others.substring(0,i)+others.substring(i+1));
        }
    }


}
