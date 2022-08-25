package KAKAO_BLIND;

import java.util.*;

public class D18_올바른괄호 {

    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

    private static boolean solution(String s) {
        boolean answer = true;

        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < c.length; i++){
            char cur = c[i];
            if (cur == '(') stack.push(cur);
            else{ // ')'
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                if (stack.pop() == cur){
                    answer = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}
