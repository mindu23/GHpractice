package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class 괄호회전하기_76502 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, solution("[](){}"));
        Assertions.assertEquals(2, solution("}]()[{"));
        Assertions.assertEquals(0, solution("[)(]"));
        Assertions.assertEquals(0, solution("}}}"));
    }

    /**
     * A가 올바른 괄호 문자열이면 (A),[A],{A} 모두 올바른 괄호
     * A, B가 올바른 괄호 문자열이면 AB도 올바른 괄호 문자열
     * s를 왼쪽으로 x 칸만큼 회전시켜 올바른 괄호 문자열이 되도록 하라
     * S의 길이는 1이상 1000이하
     * 전체 탐색 가능
     * @param s
     * @return x번 회전해서 가능한 올바른 괄호 문자열 개수 // 올바른 괄호문자열을 만들 수 없으면 0
     */
    private static int solution(String s) {
        int answer = 0;

        // StringBuilder 로 전체 문자열 관리
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++){
            // Q사용해 올바른 괄호 문자열인지 탐색
            if(checkString(sb.toString())) answer++;
            char c = sb.toString().charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }


        return answer;
    }

    private static boolean checkString(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[' || c == '{' || c == '(') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char peek = stack.peek();
                if (peek == '[' && c == ']') stack.pop();
                else if (peek == '{' && c == '}') stack.pop();
                else if (peek == '(' && c == ')') stack.pop();
                else stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
