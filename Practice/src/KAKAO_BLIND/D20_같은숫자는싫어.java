package KAKAO_BLIND;

import java.util.*;

public class D20_같은숫자는싫어 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
    }

    private static int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> ans = new ArrayList<>();
        int be = arr[0];
        ans.add(be);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == be) continue;
            be = arr[i];
            ans.add(be);
        }

        answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
}
