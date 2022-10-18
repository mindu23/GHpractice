package L2_연습문제;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D1_최댓값과최솟값 {

    @Test
    public static void main(String[] args) {
        Assertions.assertEquals(solution("1 2 3 4"), "1 4");
    }

    private static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        StringTokenizer st = new StringTokenizer(s);
        LinkedList<Integer> list = new LinkedList<>();

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        answer.append(list.get(0)+" ");
        answer.append(list.get(list.size()-1));
        return answer.toString();
    }
}
