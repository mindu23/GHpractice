package KAKAO_BLIND;

import java.util.HashMap;

public class D17_성격유형검사하기 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5})); // TCMA
    }

    private static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = new char[]{'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], 0);
        }
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] == 4) continue;
            char m = ' ';
            int k = 0;
            if (choices[i] == 1 || choices[i] == 7) k = 3;
            else if (choices[i] == 2 || choices[i] == 6) k = 2;
            else k = 1;

            if (choices[i] < 4) {
                map.put(survey[i].charAt(0), map.get(survey[i].charAt(0))+ k);
            }else {
                map.put(survey[i].charAt(1), map.get(survey[i].charAt(1))+ k);
            }
        }

        answer.append(map.get('R')<map.get('T')?'T':'R');
        answer.append(map.get('C')<map.get('F')?'F':'C');
        answer.append(map.get('J')<map.get('M')?'M':'J');
        answer.append(map.get('A')<map.get('N')?'N':'A');

        return answer.toString();
    }
}
