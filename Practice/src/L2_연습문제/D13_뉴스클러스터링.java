package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class D13_뉴스클러스터링 {

    public static void main(String[] args) {
        Assertions.assertEquals(16384, solution("FRANCE", "french"));
        Assertions.assertEquals(65536, solution("handshake", "shake hands"));
        Assertions.assertEquals(43690, solution("aa1+aa2", "AAAA12"));
        Assertions.assertEquals(65536, solution("E=M*C^2", "e=m*c^2"));

    }

    /**
     * 문자열 유사도 계산
     * 문자를 두글자씩 끊어 다중집합을 만든다. 영문자로 된 글자 쌍만 유효하고, 공백/숫자/특수문자가 포함된 쌍은 버린다.
     * STR+ -> ST TR ("R+" <- 버림):  총 2개
     * 대문자, 소문자 구분 X
     * @param str1
     * @param str2
     * @return (교집합 / 합집합) * 65536
     */
    private static int solution(String str1, String str2) {
        System.out.println("problem: "+pro++);
        int answer = 0;

        // 대소문자 구분 X
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // str1의 다중집합
        HashMap<String, Integer> hm1 = new HashMap<>();
        for (int i = 1; i < str1.length(); i++) {
            String s = String.valueOf(str1.charAt(i-1)+""+str1.charAt(i));
            // 공백/숫자/특수문자는 삭제
            if(s.matches("(.*)[^A-Z](.*)")) continue;
            hm1.put(s, hm1.getOrDefault(s, 0)+1);
        }

        // str2의 다중집합
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 1; i < str2.length(); i++) {
            String s = String.valueOf(str2.charAt(i-1)+""+str2.charAt(i));
            if (s.matches("(.*)[^A-Z](.*)")) continue;
            hm2.put(s, hm2.getOrDefault(s, 0)+1);
        }

        // 교집합
        double a = 0;
        double h1Size = 0;
        double h2Size = 0;
        for (String s : hm1.keySet()) {
            h1Size += hm1.get(s);
            if (hm2.containsKey(s)){
                int h1Cnt = hm1.get(s);
                int h2Cnt = hm2.get(s);
                a += Math.min(h1Cnt, h2Cnt);
            }
        }

        for (int cnt : hm2.values()){
            h2Size += cnt;
        }

        // 합집합
        double b = h1Size + h2Size - a;

        if(a == 0 && b == 0) return 65536;
        answer = (int)((a/b) * 65536);
        return answer;
    }
    static int pro = 1;

}
