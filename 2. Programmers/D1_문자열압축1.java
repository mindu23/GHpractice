package study;

import java.util.Arrays;

public class D1_문자열압축1 {

    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println("압축할 문자열은 "+s+"이고, 길이는 "+s.length());
        int ans = solution(s);
        System.out.println(ans);
    }

    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        char[] c = s.toCharArray();
        String res = "";

        for(int i = 1; i <= c.length/2+1; i++) {
            res = "";
            // i는 반복되는 문자열 길이
            char[] pattern = new char[i];
            char[] compare = new char[i];
            // 첫번째 패턴
            for(int k = 0; k < i; k++) {
                pattern[k] = c[k];
            }

            int n = 1;
            t: for(int j = i; j < c.length; j += i) {
                int m = 0;
                for(int k = j; k < j+i; k++) {
                    if(k >= c.length) {
                        res += String.valueOf(compare).substring(0, m);
                        break t;
                    }
                    compare[m++] = c[k];
                }

                if(!String.valueOf(pattern).equals(String.valueOf(compare))) {
                    if(n > 1) {
                        res += String.valueOf(n) + String.valueOf(pattern);
                    }else {
                        res += String.valueOf(pattern);
                    }
                    n = 1;
                    pattern = Arrays.copyOf(compare, compare.length);
                }else {
                    n++;
                }
            }
            if(n > 1) {
                res += String.valueOf(n) + String.valueOf(pattern);
            }else {
                res += String.valueOf(pattern);
            }


            System.out.println(i+"단위면 문자열은 "+res+ "이고, 길이는 "+res.length());
            answer = Math.min(answer, res.length());
        }

        return answer;
    }

}
