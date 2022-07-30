package KAKAO_BLIND;

import java.util.Arrays;
import java.util.Comparator;

public class D8_가장큰수 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{6, 10, 2}));
    }

    private static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 내림차순 정렬
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (str[0].equals("0")) return "0";

        for (String s : str) answer += s;

        return answer;
    }
}
