package KAKAO_BLIND;

import java.util.Arrays;

public class D9_모의고사 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(solution));
    }

    static class P implements Comparable<P>{
        int n;
        int cnt;

        public P(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(P o){
            return Integer.compare(o.cnt, this.cnt);
        }
    }

    private static int[] solution(int[] answers) {
        // 1번 수포자는 12345 반복
        int[] one = {1,2,3,4,5};
        int oneAns = 0;
        // 2번 수포자는 21232425 반복
        int[] two = {2,1,2,3,2,4,2,5};
        int twoAns = 0;
        // 3번 수포자는 3311224455 반복
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int threeAns = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i%5]) oneAns++;
            if (answers[i] == two[i%8]) twoAns++;
            if (answers[i] == three[i%10]) threeAns++;
        }

        P[] res = new P[3];
        res[0] = new P(1, oneAns);
        res[1] = new P(2, twoAns);
        res[2] = new P(3, threeAns);

        Arrays.sort(res);
        int max = res[0].cnt;
        int len = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i].cnt == max) len++;
        }

        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = res[i].n;
        }

        return answer;
    }
}
