package KAKAO_BLIND;

import java.util.Arrays;
import java.util.HashMap;

public class D19_전화번호목록 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421", "1195524420"}));
    }

    /**
     * phone_book의 어떤 번호가 다른 번호의 접두어인 경우 false, 아니면 true
     */
    private static boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book); // [119, 1195524420, 1195524421, 97674223]
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return answer;
    }

}
